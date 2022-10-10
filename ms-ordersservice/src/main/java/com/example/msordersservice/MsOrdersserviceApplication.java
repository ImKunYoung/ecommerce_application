package com.example.msordersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsOrdersserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsOrdersserviceApplication.class, args);
    }

}
