package com.aimeow.iteastyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@EnableAutoConfiguration
@RestController
@EnableSwagger2
@ComponentScan({"com.aimeow.iteastyle.service"
        ,"com.aimeow.iteastyle.manager"
        ,"com.aimeow.iteastyle.dao"})
public class Application {
    @RequestMapping("/")
    public String greet() {
        return "Hello world";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
