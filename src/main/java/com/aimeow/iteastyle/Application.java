package com.aimeow.iteastyle;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableSwagger2
@RestController
@ComponentScan({
        "com.aimeow.iteastyle",
        "com.aimeow.iteastyle.service",
        "com.aimeow.iteastyle.config",
        "com.aimeow.iteastyle.Authentification.service",
        "com.aimeow.iteastyle.Authentification.config",
        "com.aimeow.tools"})
public class Application {

    @ApiIgnore
    @RequestMapping("/")
    public String greeting() {
        return "hello world";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
