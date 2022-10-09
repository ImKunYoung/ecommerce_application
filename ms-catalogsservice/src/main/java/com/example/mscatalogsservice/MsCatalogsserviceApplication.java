package com.example.mscatalogsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsCatalogsserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCatalogsserviceApplication.class, args);
    }

}
