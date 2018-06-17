package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.CaseVO;
import com.aimeow.iteastyle.domain.GetCasesVO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.service.CaseService;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CaseServiceImpl implements CaseService {
    @Override
    public Result<CaseVO> getCaseById(
            @NonNull String caseId) {
        return null;
    }

    @Override
    public Result<GetCasesVO> getCases(
            Integer page, Integer pageSize) {
        return null;
    }
}
