package com.example.msadiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsaDiscoveryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaDiscoveryserviceApplication.class, args);
    }
    /*TODO: -issue 토큰 부분: r14 - 36*/

}
