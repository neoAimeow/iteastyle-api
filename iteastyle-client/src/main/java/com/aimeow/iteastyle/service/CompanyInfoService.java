package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CompanyInfoService {
    @RequestMapping(value = "/company/getInfo", method = RequestMethod.GET, consumes="application/json")
    Result<CompanyInfoVO> getCompanyInfo();
}
