package com.imooc.miaosha.redis;

/**
 * @author Bob Simon
 * @desc redis 用户key
 */
public class UserKey extends BasePrefix{

	private UserKey(String prefix) {
		super(prefix);
	}

	public static UserKey getById = new UserKey("id");

	public static UserKey getByName = new UserKey("name");

}
