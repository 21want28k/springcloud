package com.xx.springcloud.controller;

import com.xx.springcloud.entity.CommonResult;
import com.xx.springcloud.entity.Payment;
import com.xx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author xx
 * @date 2021/9/12 16:46
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/save")
    // 用@RequestBody注解的原因，是解析post请求中restTemplate，body内容。如果没有，body就无法被解析，
    public CommonResult save(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        if (result > 0) {
            return new CommonResult(200, "插入成功" + port);
        } else {
            return new CommonResult(444, "插入失败" + port);
        }
    }

    @GetMapping("/payment/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查找成功"+ port, payment);
        } else {
            return new CommonResult<>(444, "查找失败"+ port);
        }
    }
}