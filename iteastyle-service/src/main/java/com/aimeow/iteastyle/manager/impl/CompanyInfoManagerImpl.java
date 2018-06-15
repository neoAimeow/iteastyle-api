package com.aimeow.iteastyle.manager.impl;

import com.aimeow.iteastyle.converter.CompanyInfoConverter;
import com.aimeow.iteastyle.dao.CompanyInfoDAO;
import com.aimeow.iteastyle.domain.CompanyInfoBO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.manager.CompanyInfoManager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyInfoManagerImpl
        implements CompanyInfoManager {
    @Autowired private CompanyInfoDAO companyInfoDAO;

    @Override
    public Result<CompanyInfoBO> getCompanyInfo() throws Exception {
        Result<CompanyInfoBO> result = new Result<>();
        result.setModel(CompanyInfoConverter.convertDTB(
                companyInfoDAO.getCompanyInfo()));
        return result;
    }

    @Override
    public Result<Boolean> updateCompanyInfo(
            @NonNull CompanyInfoBO companyInfoBO) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(companyInfoDAO.replaceCompanyInfoData(
                CompanyInfoConverter.convertBTD(companyInfoBO)));
        return result;
    }
}
