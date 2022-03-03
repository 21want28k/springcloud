package alibaba.service.impl;


import alibaba.dao.OrderDao;
import alibaba.service.AccountService;
import alibaba.service.OrderService;
import alibaba.service.StorageService;
import domain.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @GlobalTransactional(name = "default", rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("-------->开始创建新订单");
        orderDao.create(order);
        log.info("--------订单微服务开始调用库存,做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------订单微服务开始调用库存，做扣减end");

        log.info("-------订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------订单微服务开始调用账户，做扣减end");
        log.info("-------修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("-------修改订单状态结束");

        log.info("--------下订单结束了，哈哈哈哈");
    }

    @Override
    public Order getById(Long id) {
        return orderDao.getById(id);
    }


}
