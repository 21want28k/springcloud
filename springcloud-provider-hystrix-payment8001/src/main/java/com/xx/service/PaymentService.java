package com.xx.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "   paymentInfoOk" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeoutNum = 5;
        try {
            TimeUnit.SECONDS.sleep(timeoutNum);
        } catch (InterruptedException e) {

        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeout,id" + id + "  耗时间(秒)" + timeoutNum;
    }

    public String paymentInfoTimeoutFallback(Integer id) {
        return "延迟降级";
    }

    @HystrixCommand(fallbackMethod = "circuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000")
    })
    public String circuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("****id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "流水号：+" + uuid;
    }

    public String circuitBreakerFallback(Integer id) {
        return "保险方法已经调用，id号是" + id;
    }
}