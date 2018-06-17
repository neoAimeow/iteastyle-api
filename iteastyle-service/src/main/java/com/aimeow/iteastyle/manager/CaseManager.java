package com.aimeow.iteastyle.manager;

import com.aimeow.iteastyle.domain.CaseBO;
import com.aimeow.iteastyle.domain.Result;

import java.util.List;

public interface CaseManager {
    Result<List<CaseBO>> getCases(
            Integer status , Integer page , Integer pageSize
    ) throws Exception;

    Result<CaseBO> getCaseById(String caseId) throws Exception;
    Result<Boolean> createCase(CaseBO caseBO) throws Exception;
    Result<Boolean> updateCase(CaseBO caseBO) throws Exception;
    Result<Boolean> deleteCase(String caseId) throws Exception;
}
