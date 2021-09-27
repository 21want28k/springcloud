package com.xx.controller;

import com.xx.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    /**
     * 模拟访问成功
     *
     * @param id
     * @return
     */
    @GetMapping("/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info("result:" + result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String paymetInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("result:" + result);
        return result;
    }

    @GetMapping("/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.circuitBreaker(id);
        log.info("result:" + result);
        return result;
    }
}