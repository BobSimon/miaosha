package com.imooc.miaosha.redis;

/**
 * @author Bob Simon
 * @desc 设置商品的redis key
 */
public class GoodsKey extends BasePrefix {

    private GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static GoodsKey getMiaoshaGoodsStock= new GoodsKey(0, "gs");

    public static GoodsKey getGoodsList = new GoodsKey(60, "gl");

    public static GoodsKey getGoodsDetail = new GoodsKey(60, "gd");

}