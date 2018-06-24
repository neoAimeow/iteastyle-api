package com.aimeow.iteastyle.manager;

import com.aimeow.iteastyle.domain.CaseTypeBO;
import com.aimeow.iteastyle.domain.Result;

import java.util.List;

public interface CaseTypeManager {
    Result<List<CaseTypeBO>> getCaseTypes() throws Exception;
    Result<CaseTypeBO> getCaseTypeByTypeCode(Integer type) throws Exception;
    Result<Boolean> createCaseType(CaseTypeBO caseTypeDO) throws Exception;
    Result<Boolean> updateCaseType(CaseTypeBO caseTypeDO) throws Exception;
    Result<Boolean> removeCaseType(String caseTypeId) throws Exception;
}
