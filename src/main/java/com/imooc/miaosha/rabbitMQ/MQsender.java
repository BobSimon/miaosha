package com.imooc.miaosha.rabbitMQ;

import com.imooc.miaosha.redis.RedisService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

/**
 * @author Bob Simon
 * @desc 发送信息
 */
public class MQsender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(Object message){
        String msg = RedisService.beanToString(message);
        amqpTemplate.convertAndSend(MQconfig.QUEUE,msg);
    }

    /**
     * 推送主题
     * @param message
     */
    public void sendTopic(Object message){
        String msg = RedisService.beanToString(message);
        amqpTemplate.convertAndSend(MQconfig.TOPIC_EXCHANGE,"topic.key1",msg+"1");
    }

    /**
     * 发送秒杀信息
     * @param miaoshaMessage
     */
    public void sendMiaoshaMessage(MiaoshaMessage miaoshaMessage){
        String msg = RedisService.beanToString(miaoshaMessage);
        amqpTemplate.convertAndSend(MQconfig.MIAOSHA_QUEUE,msg);
    }

}
