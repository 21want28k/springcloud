package com.xx.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xx
 * @date 2021/9/12 14:07
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {
    public int save(Payment payment);

    public Payment getById(@Param("id") Long id);

    int insertAll(Payment payment);
}