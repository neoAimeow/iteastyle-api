package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import org.springframework.stereotype.Service;

@Service
public interface CompanyInfoService {
    Result<CompanyInfoVO> getCompanyInfo();
}
