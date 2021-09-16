package com.xx.springcloud.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author xx
 * @date 2021/9/12 10:36
 */
public class Payment implements Serializable {
    private Long id;
    private String serial;

    public Payment() {
    }

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId()) && Objects.equals(getSerial(), payment.getSerial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSerial());
    }
}