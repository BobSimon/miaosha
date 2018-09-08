package com.imooc.miaosha.controller;

import com.imooc.miaosha.redis.GoodsKey;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.vo.GoodsDetailVo;
import com.imooc.miaosha.vo.GoodsVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.MiaoshaUserService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring4.context.SpringWebContext;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/goods")

/**
 * @author Bob Simon
 * @desc 商品控制层
 */
public class GoodsController {

	@Autowired
	MiaoshaUserService userService;

	@Autowired
	GoodsService goodsService;

	@Autowired
	RedisService redisService;

	@Autowired
	ThymeleafViewResolver thymeleafViewResolver;

	@Autowired
	org.springframework.context.ApplicationContext applicationContext;
	
    @RequestMapping(value = "/to_list",produces = "text/html")
	@ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response, Model model, MiaoshaUser user) {
    	model.addAttribute("user", user);
    	//先取缓存
    	String html = redisService.get(GoodsKey.getGoodsList,"",String.class);
    	if(!StringUtils.isEmpty(html)){
    		return html;
		}
		//若是取不到，则手动渲染，并存储到缓存中
		List<GoodsVo> goodsVoList = goodsService.listGoodsVo();
		model.addAttribute("goodsList", goodsVoList);

		SpringWebContext ctx = new SpringWebContext(request,response,request.getServletContext(),request.getLocale(),model.asMap(),applicationContext);
		html = thymeleafViewResolver.getTemplateEngine().process("goods_list",ctx);
		if(!StringUtils.isEmpty(html)){
			redisService.set(GoodsKey.getGoodsList,"",html);
		}

        return html;
    }

	@RequestMapping(value = "/to_detail/{goodsId}",produces = "text/html")
	@ResponseBody
	public String detail(HttpServletRequest request,HttpServletResponse response,Model model, MiaoshaUser user,
						 @PathVariable("goodsId")long goodsId) {
		model.addAttribute("user", user);

		//取缓存
		String html = redisService.get(GoodsKey.getGoodsDetail,""+goodsId,String.class);
		if(!StringUtils.isEmpty(html)){
			return html;
		}
		//手动渲染

		GoodsVo goodsVo = goodsService.getGoodsVoGetById(goodsId);
		model.addAttribute("goods",goodsVo);

		long startAt = goodsVo.getStartDate().getTime();
		long endAt = goodsVo.getEndDate().getTime();
		long now = System.currentTimeMillis();

		int miaoshaStatus=0;
		int remainSeconds=0;

		if(now<startAt){
			miaoshaStatus=0;
			remainSeconds=(int)(startAt-now);
		} else if(now>endAt){
			miaoshaStatus =2;
			remainSeconds=-1;
		} else{
			miaoshaStatus =1;
			remainSeconds=0;
		}
		model.addAttribute("miaoshaStatus",miaoshaStatus);
		model.addAttribute("remainSeconds",remainSeconds);

		SpringWebContext ctx = new SpringWebContext(request,response,request.getServletContext(),request.getLocale(),model.asMap(),applicationContext);

		html = thymeleafViewResolver.getTemplateEngine().process("goods_detail",ctx);
		if(!StringUtils.isEmpty(html)){
			redisService.set(GoodsKey.getGoodsDetail,""+goodsId,html);
		}
		return html;
	}
	@RequestMapping(value="/detail/{goodsId}")
	@ResponseBody
	public Result<GoodsDetailVo> detail2(HttpServletRequest request, HttpServletResponse response, Model model, MiaoshaUser user,
										 @PathVariable("goodsId")long goodsId) {
		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
		long startAt = goods.getStartDate().getTime();
		long endAt = goods.getEndDate().getTime();
		long now = System.currentTimeMillis();
		int miaoshaStatus = 0;
		int remainSeconds = 0;
		//秒杀还没开始，倒计时
		if(now < startAt) {
			miaoshaStatus = 0;
			remainSeconds = (int)((startAt - now )/1000);
			//秒杀已经结束
		}else if(now > endAt){
			miaoshaStatus = 2;
			remainSeconds = -1;
			//秒杀进行中
		}else {
			miaoshaStatus = 1;
			remainSeconds = 0;
		}
		GoodsDetailVo vo = new GoodsDetailVo();
		vo.setGoods(goods);
		vo.setUser(user);
		vo.setRemainSeconds(remainSeconds);
		vo.setMiaoshaStatus(miaoshaStatus);
		return Result.success(vo);
	}
    
}
