package com.atguigu.springcloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME="boot_topic_exchange";
    public static final String QUEUE_NAME="boot_queue";


    @Bean("bootExchange")
    public Exchange bootExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    @Bean("bootQueue")
    public Queue bootQueue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue,@Qualifier("bootExchange")  Exchange exchange){
      return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }

}
