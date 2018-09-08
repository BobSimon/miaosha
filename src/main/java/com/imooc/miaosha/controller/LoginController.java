package com.imooc.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.vo.LoginVo;

@Controller
@RequestMapping("/login")

/**
 * @author Bob Simon
 * @desc 用户登录控制层
 */
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MiaoshaUserService userService;
	
	@Autowired
	RedisService redisService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录的逻辑判断
     * @param response
     * @param loginVo
     * @return
     */
    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response,@Valid LoginVo loginVo) {
    	log.info(loginVo.toString());
    	String token = userService.login(response, loginVo);
    	return Result.success(token);
    }


}
