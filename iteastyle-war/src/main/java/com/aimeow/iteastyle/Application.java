package com.aimeow.iteastyle;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@EnableAutoConfiguration
@RestController
@EnableSwagger2
@ComponentScan({"com.aimeow.iteastyle.service"
        ,"com.aimeow.iteastyle.manager"
        ,"com.aimeow.iteastyle.dao"})
@Api(value = "/", hidden=true)
public class Application {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String greet() {
        return "Hello world";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
