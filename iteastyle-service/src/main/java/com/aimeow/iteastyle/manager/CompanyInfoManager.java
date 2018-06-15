package com.aimeow.iteastyle.manager;

import com.aimeow.iteastyle.domain.CompanyInfoBO;
import com.aimeow.iteastyle.domain.Result;

public interface CompanyInfoManager {
    Result<CompanyInfoBO> getCompanyInfo() throws Exception;
    Result<Boolean> updateCompanyInfo(
            CompanyInfoBO companyInfoBO) throws Exception;
}
