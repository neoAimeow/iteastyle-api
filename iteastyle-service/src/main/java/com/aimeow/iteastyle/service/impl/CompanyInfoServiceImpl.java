package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.converter.CompanyInfoConverter;
import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.manager.CompanyInfoManager;
import com.aimeow.iteastyle.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyInfoServiceImpl
        implements CompanyInfoService {
    @Autowired private CompanyInfoManager companyInfoManager;

    @Override
    public Result<CompanyInfoVO> getCompanyInfo() {
        Result<CompanyInfoVO> result = new Result<>();
        try {
            result.setModel(CompanyInfoConverter.convertBTV(
                    companyInfoManager.getCompanyInfo().getModel())
            );
        } catch (Exception e) {

        }
        return result;
    }
}
