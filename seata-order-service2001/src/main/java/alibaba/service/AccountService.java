package alibaba.service;

import com.xx.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId,
                          @RequestParam("money")BigDecimal money);
}
