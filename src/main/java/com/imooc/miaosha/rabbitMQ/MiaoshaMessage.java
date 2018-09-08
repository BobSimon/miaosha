package com.imooc.miaosha.rabbitMQ;

import com.imooc.miaosha.domain.MiaoshaUser;

/**
 * @author Bob Simon
 * @desc 秒杀信息
 */
public class MiaoshaMessage {

    private MiaoshaUser user;

    private long gooddsId;

    public MiaoshaUser getUser() {
        return user;
    }

    public void setUser(MiaoshaUser user) {
        this.user = user;
    }

    public long getGooddsId() {
        return gooddsId;
    }

    public void setGooddsId(long gooddsId) {
        this.gooddsId = gooddsId;
    }

}
