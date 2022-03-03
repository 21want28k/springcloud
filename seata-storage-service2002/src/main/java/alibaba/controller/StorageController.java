package alibaba.controller;

import alibaba.service.StorageService;
import com.xx.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping(value = "/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"库存扣减成功，哈哈哈哈");
    }
}
