package com.example.msuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsUserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsUserserviceApplication.class, args);
    }

}
