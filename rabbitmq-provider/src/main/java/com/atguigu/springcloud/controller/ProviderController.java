package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProviderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/mq/{message}")
    public void send(@PathVariable("message") String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "boot.haha", message);
    }
}
