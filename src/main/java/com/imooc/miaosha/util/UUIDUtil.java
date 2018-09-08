package com.imooc.miaosha.util;

import java.util.UUID;

/**
 * @author Bob Simon
 * @desc 获取UUID
 */
public class UUIDUtil {

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
