package com.example.msagatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaGatewayserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsaGatewayserviceApplication.class, args);
    }

}
