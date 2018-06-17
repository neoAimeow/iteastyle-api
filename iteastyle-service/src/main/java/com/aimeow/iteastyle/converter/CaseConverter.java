package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.CaseBO;
import com.aimeow.iteastyle.domain.CaseDO;
import com.aimeow.iteastyle.domain.CaseVO;

public class CaseConverter {
    public static CaseBO convertDTB(CaseDO caseDO) {
        CaseBO caseBO = new CaseBO();
        caseBO.setId(caseDO.getId());
        caseBO.setTitle(caseDO.getTitle());
        caseBO.setGmtCreate(caseDO.getGmtCreate());
        caseBO.setGmtModified(caseDO.getGmtModified());
        return caseBO;
    }

    public static CaseDO convertBTD(CaseBO caseBO) {
        CaseDO caseDO = new CaseDO();
        caseDO.setId(caseBO.getId());
        caseDO.setTitle(caseBO.getTitle());
        caseDO.setGmtCreate(caseBO.getGmtCreate());
        caseDO.setGmtModified(caseBO.getGmtModified());
        return caseDO;
    }

    public static CaseVO convertBTV(CaseBO caseBO) {
        CaseVO caseVO = new CaseVO();
        return caseVO;
    }
}
