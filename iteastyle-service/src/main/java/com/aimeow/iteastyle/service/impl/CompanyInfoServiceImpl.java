package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.service.CompanyInfoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Override
    public String print() {
        return "hello worldtest";
    }
}
