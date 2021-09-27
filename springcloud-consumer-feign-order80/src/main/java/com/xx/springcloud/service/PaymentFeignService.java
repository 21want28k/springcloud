package com.xx.springcloud.service;

import com.xx.springcloud.entity.CommonResult;
import com.xx.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id);
}