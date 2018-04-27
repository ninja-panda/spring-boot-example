package com.tuturself.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Arpan Das
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tuturself.webservice"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot 2.0 File Upload example with Consul Integration & Swagger 2.8.0")
                .description("Upload file with Swagger-ui 2.8.0 using Spring Boot 2.0 Spring Cloud Consul")
                .version("version 1.0")
                .contact(new Contact("Tutu'rself", "https://www.tuturself.com", "arpan.kgp@gmail.com"))
                .build();
    }
}