package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CaseVO;
import com.aimeow.iteastyle.domain.GetCasesVO;
import com.aimeow.iteastyle.domain.Result;

public interface CaseService {
    Result<CaseVO> getCaseById(String caseId);
    Result<GetCasesVO> getCases(Integer page , Integer pageSize);
}
