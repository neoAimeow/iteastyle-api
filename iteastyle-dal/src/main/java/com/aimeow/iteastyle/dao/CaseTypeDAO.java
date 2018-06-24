package com.aimeow.iteastyle.dao;

import com.aimeow.iteastyle.domain.CaseTypeDO;

import java.util.List;

public interface CaseTypeDAO {
    List<CaseTypeDO> getCaseTypes() throws Exception;
    CaseTypeDO getCaseTypeByTypeCode(Integer type) throws Exception;
    Boolean createCaseType(CaseTypeDO caseTypeDO) throws Exception;
    Boolean updateCaseType(CaseTypeDO caseTypeDO) throws Exception;
    Boolean removeCaseType(String caseTypeId) throws Exception;
}
