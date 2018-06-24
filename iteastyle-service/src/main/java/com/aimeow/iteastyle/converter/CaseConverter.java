package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.CaseBO;
import com.aimeow.iteastyle.domain.CaseDO;
import com.aimeow.iteastyle.domain.CaseVO;

public class CaseConverter {
    public static CaseBO convertDTB(CaseDO caseDO) {
        CaseBO caseBO = new CaseBO();
        caseBO.setId(caseDO.getId());
        caseBO.setTitle(caseDO.getTitle());
        caseBO.setType(caseDO.getType());
        caseBO.setImageArr(caseDO.getImageArr());
        caseBO.setGmtCreate(caseDO.getGmtCreate());
        caseBO.setGmtModified(caseDO.getGmtModified());
        return caseBO;
    }

    public static CaseDO convertBTD(CaseBO caseBO) {
        CaseDO caseDO = new CaseDO();
        caseDO.setId(caseBO.getId());
        caseDO.setTitle(caseBO.getTitle());
        caseDO.setType(caseBO.getType());
        caseDO.setImageArr(caseBO.getImageArr());
        caseDO.setGmtCreate(caseBO.getGmtCreate());
        caseDO.setGmtModified(caseBO.getGmtModified());
        return caseDO;
    }

    public static CaseVO convertBTV(CaseBO caseBO) {
        CaseVO caseVO = new CaseVO();
        caseVO.setId(caseBO.getId());
        caseVO.setTitle(caseBO.getTitle());
        caseVO.setType(caseBO.getType());
        caseVO.setImageArr(caseBO.getImageArr());
        caseVO.setGmtCreate(caseBO.getGmtCreate());
        caseVO.setGmtModified(caseBO.getGmtModified());
        return caseVO;
    }
}
