package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    public String configInfo;




    @GetMapping("/config/info")
    public String getConfigInfo(){

        return configInfo;
    }
}
