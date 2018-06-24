package com.aimeow.iteastyle.manager.impl;

import com.aimeow.iteastyle.converter.CaseTypeConverter;
import com.aimeow.iteastyle.dao.CaseTypeDAO;
import com.aimeow.iteastyle.domain.CaseTypeBO;
import com.aimeow.iteastyle.domain.CaseTypeDO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.manager.CaseTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CaseTypeManagerImpl implements CaseTypeManager {
    @Autowired private CaseTypeDAO caseTypeDAO;

    @Override
    public Result<CaseTypeBO> getCaseTypeByTypeCode(Integer type) throws Exception {
        Result<CaseTypeBO> result = new Result<>();
        result.setModel(CaseTypeConverter.convertDTB(caseTypeDAO.getCaseTypeByTypeCode(type)));
        return result;
    }

    @Override
    public Result<List<CaseTypeBO>> getCaseTypes() throws Exception {
        Result<List<CaseTypeBO>> result = new Result<>();
        List<CaseTypeBO> caseTypeBOS = new ArrayList<>();
        List<CaseTypeDO> caseTypeDOS = caseTypeDAO.getCaseTypes();
        caseTypeDOS.iterator().forEachRemaining(
                obj-> {
                    caseTypeBOS.add(CaseTypeConverter.convertDTB(obj));
                }
        );
        result.setModel(caseTypeBOS);
        return result;
    }

    @Override
    public Result<Boolean> createCaseType(CaseTypeBO caseTypeBO) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(caseTypeDAO.createCaseType(CaseTypeConverter.convertBTD(caseTypeBO)));
        return result;
    }

    @Override
    public Result<Boolean> updateCaseType(CaseTypeBO caseTypeBO) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(caseTypeDAO.updateCaseType(CaseTypeConverter.convertBTD(caseTypeBO)));
        return result;
    }

    @Override
    public Result<Boolean> removeCaseType(String caseTypeId) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(caseTypeDAO.removeCaseType(caseTypeId));
        return result;
    }
}
