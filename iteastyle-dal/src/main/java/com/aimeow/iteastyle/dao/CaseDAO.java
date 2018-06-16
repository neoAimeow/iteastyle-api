package com.aimeow.iteastyle.dao;

import com.aimeow.iteastyle.domain.CaseDO;
import com.aimeow.iteastyle.domain.query.CaseQuery;

import java.util.List;

public interface CaseDAO {
    List<CaseDO> queryCases(
            CaseQuery query) throws Exception;
    CaseDO queryCaseById(
            CaseQuery query) throws Exception;
    Long countCases(
            CaseQuery query) throws Exception;
    Boolean createCase(
            CaseDO caseDO) throws Exception;
    Boolean updateCase(
            CaseDO caseDO) throws Exception;
    Boolean deleteCaseById(
            String caseId) throws Exception;
}
