package com.tuturself;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by Arpan Das on 4/17/2018.
 */

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration
public class SpringBoot2FileUpload {

    public static void main(String[] args) {
        log.info("SpringBoot2FileUpload Application is Starting...");
        try {
            SpringApplication.run(SpringBoot2FileUpload.class, args);
        } catch (Exception e) {
            log.error("Error occurred while starting SpringBoot2FileUpload");
        }
        log.info("SpringBoot2FileUpload Application Started..");
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(-1);
        return multipartResolver;
    }
}
