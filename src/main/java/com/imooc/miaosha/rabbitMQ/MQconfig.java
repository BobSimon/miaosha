package com.imooc.miaosha.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

/**
 * @author Bob Simon
 * @desc mq的配置信息
 */
public class MQconfig {

    public static final String MIAOSHA_QUEUE = "miaosha.queue";

    public static final String QUEUE = "queue";

    public static final String TOPIC_QUEUE1= "topic.queue1";

    public static final String TOPIC_QUEUE2 = "topic.queue2";

    public static final String TOPIC_EXCHANGE = "topicExchange";

    public static final String ROUNTING_KEY1 = "rountingKey1";

    public static final String ROUNTING_KEY2 = "rountingKey2";

    public static final String FANOUT_EXCHANGE = "fanoutxchage";

    public static final String HEADERS_EXCHANGE = "headersExchage";

    /**
     * Direct模式
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("queue",true);
    }

    @Bean
    public Queue miaoshaQueue(){
        return new Queue(MIAOSHA_QUEUE,true);
    }

    /**
     * topic交换机模式
     * @return
     */
    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE1,true);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE2,true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.key1");
    }

    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.#");
    }

    /**
     * Fanout模式，广播模式
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    //绑定就好，略


    //最后一种模式，header模式
    //类似于协议报头？？？

}
