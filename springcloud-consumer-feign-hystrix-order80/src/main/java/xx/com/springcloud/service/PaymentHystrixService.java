package xx.com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
@Component
@RequestMapping("/payment/hystrix")
public interface PaymentHystrixService {
    @GetMapping("/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id);

    @GetMapping("/timeout/{id}")
    public String paymetInfoTimeout(@PathVariable("id") Integer id);


}