package com.imooc.miaosha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

/**
 * @author Bob Simon
 * @desc 主程序入口
 */
public class MainApplication {


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		System.out.println("秒杀服务开启成功！！");
	}


}
