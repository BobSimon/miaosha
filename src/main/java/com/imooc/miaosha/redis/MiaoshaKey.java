package com.imooc.miaosha.redis;

/**
 * @author Bob Simon
 * @desc 秒杀 redis key
 */
public class MiaoshaKey extends BasePrefix {

    private MiaoshaKey(String prefix) {
        super(0, prefix);
    }

    public static MiaoshaKey isGoodsOver = new MiaoshaKey("go");
}
