package com.xx.springcloud.entity;

import java.util.Objects;

/**
 * @author xx
 * @date 2021/9/12 10:44
 */
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonResult<?> that = (CommonResult<?>) o;
        return Objects.equals(getCode(), that.getCode()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMessage(), getData());
    }
}