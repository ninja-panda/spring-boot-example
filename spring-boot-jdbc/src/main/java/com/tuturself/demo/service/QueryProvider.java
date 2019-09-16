package com.tuturself.demo.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:/Queries.properties")
public class QueryProvider {

    @Value("${city}")
    private String city;

    @Value("${country}")
    private String country;

    @Value("${add.country}")
    private String addCountry;

    @Value("${add.city}")
    private String addCity;

    @Value("${update.country}")
    private String updateCountry;

    @Value("${update.city}")
    private String updateCity;
}
