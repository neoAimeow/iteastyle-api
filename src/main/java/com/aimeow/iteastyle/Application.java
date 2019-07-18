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

@SpringBootConfiguration
@EnableAutoConfiguration
@RestController
@ComponentScan({
        "com.aimeow.iteastyle",
        "com.aimeow.iteastyle.service",
        "com.aimeow.iteastyle.config",
        "com.aimeow.iteastyle.Authentification.service",
        "com.aimeow.iteastyle.Authentification.config",
        "com.aimeow.iteastyle.tools"})
public class Application {

    @RequestMapping("/")
    public String greeting() {
        return "hello world";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
