package com.aimeow.iteastyle.manager.impl;

import com.aimeow.iteastyle.converter.CaseConverter;
import com.aimeow.iteastyle.dao.CaseDAO;
import com.aimeow.iteastyle.domain.CaseBO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.query.CaseQuery;
import com.aimeow.iteastyle.manager.CaseManager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseManagerImpl implements CaseManager {
    @Autowired private CaseDAO caseDAO;

    @Override
    public Result<CaseBO> getCaseById(
            @NonNull String caseId) throws Exception {
        Result<CaseBO> result = new Result<>();
        CaseQuery query = new CaseQuery();
        query.setCaseId(caseId);
        result.setModel(CaseConverter
                .convertDTB(caseDAO.queryCaseById(query)));
        return result;
    }

    @Override
    public Result<List<CaseBO>> getCases(
            @NonNull Integer type, @NonNull Integer status,  Integer page, Integer pageSize) throws Exception {
        CaseQuery query = new CaseQuery();
        query.setPage(page);
        query.setPageSize(pageSize);
        query.setType(type);
        return null;
    }

    @Override
    public Result<Boolean> createCase(
            @NonNull CaseBO caseBO) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(caseDAO.createCase(
                CaseConverter.convertBTD(caseBO))
        );
        return result;
    }

    @Override
    public Result<Boolean> updateCase(
            @NonNull CaseBO caseBO) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(caseDAO.updateCase(
                CaseConverter.convertBTD(caseBO))
        );
        return result;
    }

    @Override
    public Result<Boolean> deleteCase(
            @NonNull String caseId) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(caseDAO.deleteCaseById(caseId));
        return result;
    }
}
