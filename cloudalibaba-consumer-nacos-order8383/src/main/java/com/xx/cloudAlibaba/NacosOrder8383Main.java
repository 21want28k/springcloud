package com.xx.cloudAlibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrder8383Main {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrder8383Main.class, args);
    }
}