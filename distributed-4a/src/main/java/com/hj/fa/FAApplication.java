package com.hj.fa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: 启动类
 * @Author: hejian
 * @Date: 2022-04-24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class FAApplication {

    public static void main(String[] args) {
        SpringApplication.run(FAApplication.class);
    }
}