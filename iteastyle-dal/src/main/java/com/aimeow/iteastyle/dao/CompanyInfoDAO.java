package com.aimeow.iteastyle.dao;

import com.aimeow.iteastyle.domain.CompanyInfoDO;

public interface CompanyInfoDAO {
    CompanyInfoDO getCompanyInfo() throws Exception;
    Boolean replaceCompanyInfoData(
            CompanyInfoDO companyInfoDO
    ) throws Exception;
}
