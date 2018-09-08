package com.imooc.miaosha.redis;

/**
 * @author Bob Simon
 * @desc redis key前缀
 */
public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
