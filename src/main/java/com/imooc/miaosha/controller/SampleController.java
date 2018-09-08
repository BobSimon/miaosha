package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.Goods;
import com.imooc.miaosha.rabbitMQ.MQreceiver;
import com.imooc.miaosha.rabbitMQ.MQsender;
import com.imooc.miaosha.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.UserService;

@Controller
@RequestMapping("/demo")

/**
 * @author Bob Simon
 * @desc 样例控制层
 */
public class SampleController {

	@Autowired
	UserService userService;

    @Autowired
    GoodsService goodsService;
	
	@Autowired
	RedisService redisService;

	@Autowired
    MQreceiver mQreceiver;

	@Autowired
    MQsender mQsender;
	
    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> home() {
        return Result.success("Hello，world");
    }
    
    @RequestMapping("/error")
    @ResponseBody
    public Result<String> error() {
        return Result.error(CodeMsg.SESSION_ERROR);
    }
    
    @RequestMapping("/hello/themaleaf")
    public String themaleaf(Model model) {
        model.addAttribute("name", "Joshua");
        return "hello";
    }

    /**
     * 获取用户信息的demo
     * @return
     */
    @RequestMapping("/db/get")
    @ResponseBody
    public Result<Goods> dbGet() {
    	Goods goods = goodsService.getGoodsVoByGoodsId(1);
        return Result.success(goods);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
    	userService.tx();
        return Result.success(true);
    }

    /**
     * redis get值的demo
     * @return
     */
    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
    	User user = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(user);
    }

    /**
     * redis set值的demo
     * @return
     */
    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
    	User user  = new User();
    	user.setId(1);
    	user.setName("1111");
        //UserKey:id1
    	redisService.set(UserKey.getById,""+1, user);
        return Result.success(true);
    }

    /**
     * 发送一条信息的demo
     * @param msg
     * @return
     */
    @RequestMapping("/mq")
    @ResponseBody
    public String mq(String msg){
        mQsender.send(msg);

        return "发送消息成功";
    }

    
    
}
