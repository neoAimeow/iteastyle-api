package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;

public interface CompanyInfoService {
    Result<CompanyInfoVO> getCompanyInfo();
}
