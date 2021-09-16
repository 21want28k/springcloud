package com.xx.springcloud.service.impl;

import com.xx.springcloud.dao.PaymentDao;
import com.xx.springcloud.entity.Payment;
import com.xx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xx
 * @date 2021/9/12 16:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao dao;

    @Override
    public int save(Payment payment) {
        return dao.save(payment);
    }

    @Override
    public Payment getById(Long id) {
        return dao.getById(id);
    }
}