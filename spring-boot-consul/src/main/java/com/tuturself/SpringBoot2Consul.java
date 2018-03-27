package com.tuturself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Arpan Das on 3/22/2018.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class SpringBoot2Consul {

    public static void main(String[] args) {
        System.out.println("SpringBoot2Consul Application is Starting...");
        try {
            SpringApplication.run(SpringBoot2Consul.class, args);
        } catch (Exception e) {
            System.out.println("Error occurred while starting SpringBoot2Consul");
        }
        System.out.println("SpringBoot2Consul Application Started..");
    }
}
