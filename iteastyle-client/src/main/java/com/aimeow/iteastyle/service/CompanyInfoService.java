package com.aimeow.iteastyle.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CompanyInfoService {
    @RequestMapping("/")
    String print();
}
