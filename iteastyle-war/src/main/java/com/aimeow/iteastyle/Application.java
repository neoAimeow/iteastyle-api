package com.aimeow.iteastyle;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class Application {

    @RequestMapping("/")
    String home() {
        return "Hello world";
        //TestObject testObject = new TestObject();
        //return testObject.hello();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}