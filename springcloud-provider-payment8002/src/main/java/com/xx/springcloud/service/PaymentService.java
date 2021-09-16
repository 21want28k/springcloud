package com.xx.springcloud.service;

import com.xx.springcloud.entity.Payment;

/**
 * @author xx
 * @date 2021/9/12 16:25
 */
public interface PaymentService {
    int save(Payment payment);

    Payment getById(Long id);
}