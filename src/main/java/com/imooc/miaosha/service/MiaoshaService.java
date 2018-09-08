package com.imooc.miaosha.service;

import com.imooc.miaosha.domain.*;
import com.imooc.miaosha.redis.MiaoshaKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

/**
 * @author Bob Simon
 * @desc 秒杀业务逻辑
 */
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    RedisService redisService;

    @Transactional(rollbackFor = Exception.class)
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods){
        boolean success= goodsService.reduceStock(goods);
        if(success){
            return orderService.createOrder(user,goods);
        } else {
            setGoodsOver(goods.getId());
            return null;
        }
    }

    private void setGoodsOver(Long goodsId) {
        redisService.set(MiaoshaKey.isGoodsOver,""+goodsId,true);
    }

    public long getMiaoshaResult(long userId, long goodsId) {
        MiaoshaOrder order =orderService.getOrderByUserIdGoodsId(userId,goodsId);
        if(order!=null){
            return order.getOrderId();
        } else{
            boolean isOver = getGoodsOver(goodsId);
            if(isOver){
                return -1;
            } else {
                return 0;
            }
        }
    }

    private boolean getGoodsOver(long goodsId) {
        return  redisService.exists(MiaoshaKey.isGoodsOver,""+goodsId);
    }

}
