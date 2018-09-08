package com.imooc.miaosha.rabbitMQ;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.domain.OrderInfo;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaService;
import com.imooc.miaosha.vo.GoodsVo;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service

/**
 * @author Bob Simob
 * @desc 接收信息
 */
public class MQreceiver {

    @Autowired
    GoodsService goodsService;

    @Autowired
    MiaoshaService miaoshaService;

    private static Logger log = LoggerFactory.getLogger(MQreceiver.class);

    /**
     * 监听的队列 (MQconfig.MIAOSHA_QUEUE)
     * @param message
     */
    @RabbitListener(queues = MQconfig.MIAOSHA_QUEUE)
    public void receive(String message){
        log.info("receive message:"+message);
        MiaoshaMessage mm =RedisService.stringToBean(message,MiaoshaMessage.class);
        MiaoshaUser user = mm.getUser();
        long goodsId = mm.getGooddsId();
        //判断库存 //10个商品，req1 req2
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if(stock <= 0) {
            return ;
        }
        OrderInfo orderInfo = miaoshaService.miaosha(user, goods);
    }


    /**
     * 监听的队列 (MQconfig.QUEUE)
     * @param message
     */
    @RabbitListener(queues = MQconfig.QUEUE)
    public void receiveMsg(String message){
        System.out.println("收到的信息为：" + message);
    }


}
