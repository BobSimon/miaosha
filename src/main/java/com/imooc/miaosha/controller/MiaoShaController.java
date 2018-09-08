package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.MiaoshaOrder;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.domain.OrderInfo;
import com.imooc.miaosha.rabbitMQ.MQsender;
import com.imooc.miaosha.rabbitMQ.MiaoshaMessage;
import com.imooc.miaosha.redis.GoodsKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaService;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.service.OrderService;
import com.imooc.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/miaosha")

/**
 * @author Bob Simon
 * @desc 秒杀控制层
 */
public class MiaoShaController implements InitializingBean {

	@Autowired
	MiaoshaUserService userService;

	@Autowired
	GoodsService goodsService;

	@Autowired
	OrderService orderService;

	@Autowired
	RedisService redisService;

	@Autowired
	MiaoshaService miaoshaService;


	@Autowired
	MQsender mQsender;

	//系统初始化

	@Override
	public void afterPropertiesSet() throws Exception {
		List<GoodsVo> goodsList = goodsService.listGoodsVo();
		if(goodsList == null){
			return ;
		}
		for(GoodsVo goods:goodsList){
			redisService.set(GoodsKey.getMiaoshaGoodsStock,""+goods.getId(),goods.getStockCount());
		}
	}

	/**
	 * 做秒杀操作
	 * @param model
	 * @param user
	 * @param goodsId
	 * @return
	 */
	@RequestMapping(value="/do_miaosha", method=RequestMethod.POST)
	@ResponseBody
	public Result<Integer> miaosha (Model model,MiaoshaUser user,@RequestParam("goodsId")long goodsId) {
		model.addAttribute("user", user);
		if(user == null) {
			return Result.error(CodeMsg.SESSION_ERROR);
		}
		//预减少库存
		long stock = redisService.decr(GoodsKey.getMiaoshaGoodsStock,""+goodsId);
		if(stock<0){
			return Result.error(CodeMsg.MIAO_SHA_OVER);
		}

		//判断是否已经秒杀
		MiaoshaOrder order = orderService.getOrderByUserIdGoodsId(user.getId(), goodsId);
		if(order != null) {
			return Result.error(CodeMsg.MIAO_REPEAT);
		}

		//入队列
		MiaoshaMessage miaoshaMessage = new MiaoshaMessage();
		miaoshaMessage.setGooddsId(goodsId);
		miaoshaMessage.setUser(user);
		mQsender.sendMiaoshaMessage(miaoshaMessage);
		//排队中
		return Result.success(0);

		/*
		//判断库存
		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);//10个商品，req1 req2
		int stock = goods.getStockCount();
		if(stock <= 0) {
			return Result.error(CodeMsg.MIAO_SHA_OVER);
		}
		//判断是否已经秒杀到了
		MiaoshaOrder order = orderService.getOrderByUserIdGoodsId(user.getId(), goodsId);
		if(order != null) {
			return Result.error(CodeMsg.MIAO_REPEAT);
		}
		//减库存 下订单 写入秒杀订单
		OrderInfo orderInfo = miaoshaService.miaosha(user, goods);

		return Result.success(orderInfo);
		return Result.success(orderInfo);
	}




}}*/
	}


	/**
	 * orderId:成功
	 * -1：库存不足
	 * 0：排队中
	 */
	@RequestMapping(value="/result", method=RequestMethod.GET)
	@ResponseBody
	public Result<Long> miaoshaResult(Model model,MiaoshaUser user,@RequestParam("goodsId")long goodsId) {
		model.addAttribute("user", user);
		if(user == null) {
			return Result.error(CodeMsg.SESSION_ERROR);
		}
		long result = miaoshaService.getMiaoshaResult(user.getId(),goodsId);
		return Result.success(result);
	}


}