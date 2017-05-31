package com.tuturself.spring.boot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFilterApplication {

    private final static Logger logger = LoggerFactory.getLogger(SpringFilterApplication.class);

    public static void main(String[] args) throws Exception {
        logger.debug("SpringFilterApplication is STARTing...");
        SpringApplication.run(SpringFilterApplication.class, args);
    }
}