package com.xx.service.impl;

import cn.hutool.core.util.IdUtil;
import com.xx.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("********: " + serial);
        return null;
    }
}
