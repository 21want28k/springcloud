package alibaba.controller;

import alibaba.service.OrderService;
import com.xx.springcloud.entity.CommonResult;
import domain.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功！");
    }

    @GetMapping("/order/getById")
    public CommonResult create(Long userId) {
        Order order = orderService.getById(userId);
        return new CommonResult(200, "订单创建成功！", order);
    }
}
