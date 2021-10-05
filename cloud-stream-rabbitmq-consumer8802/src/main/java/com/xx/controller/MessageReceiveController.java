package com.xx.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@EnableBinding(Sink.class)
public class MessageReceiveController {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("message: " + message.getPayload());
    }
}