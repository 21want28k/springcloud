package xx.com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xx.com.springcloud.service.PaymentHystrixService;

@RestController
@Slf4j
@RequestMapping("/consumer/payment/hystrix")
@DefaultProperties(defaultFallback = "paymentInfoTimeoutFallback",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
})
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

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
        String result = paymentHystrixService.paymentInfoOK(id);
        log.info("result:" + result);
        return result;
    }

    @GetMapping("/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    @HystrixCommand
    public String paymetInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymetInfoTimeout(id);
        log.info("result:" + result);
        return result;
    }

    public String paymentInfoTimeoutFallback(Integer id) {
        return "延迟降级";
    }
}