package com.xx.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Payment9001Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment9001Application.class);
    }
}