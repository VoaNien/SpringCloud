package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池:";
    }
}
