package com.yunli.ecology.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.yunli.ecology"})
@MapperScan(value = {"com.yunli.ecology.search.repository.mybatis"})
public class FullTextSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullTextSearchApplication.class, args);
    }

}
