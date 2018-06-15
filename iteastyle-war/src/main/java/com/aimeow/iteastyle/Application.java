package com.aimeow.iteastyle;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class Application {
    @Autowired
    private CompanyInfoService companyInfoService;

    @RequestMapping("/")
    CompanyInfoVO home() {
        return companyInfoService.getCompanyInfo().getModel();
        //TestObject testObject = new TestObject();
        //return testObject.hello();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}