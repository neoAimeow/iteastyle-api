package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.CaseTypeBO;
import com.aimeow.iteastyle.domain.CaseTypeDO;
import com.aimeow.iteastyle.domain.Case.CaseTypeVO;

public class CaseTypeConverter {
    public static CaseTypeBO convertDTB(CaseTypeDO caseTypeDO) {
        CaseTypeBO caseTypeBO = new CaseTypeBO();
        caseTypeBO.setId(caseTypeDO.getId());
        caseTypeBO.setType(caseTypeDO.getType());
        caseTypeBO.setTypeName(caseTypeDO.getTypeName());
        caseTypeBO.setTypeNameEn(caseTypeDO.getTypeNameEn());
        caseTypeBO.setTypeImage(caseTypeDO.getTypeImage());
        caseTypeBO.setTypeIcon(caseTypeDO.getTypeIcon());
        return caseTypeBO;
    }

    public static CaseTypeDO convertBTD(CaseTypeBO caseTypeBO) {
        CaseTypeDO caseTypeDO = new CaseTypeDO();
        caseTypeDO.setId(caseTypeBO.getId());
        caseTypeDO.setType(caseTypeBO.getType());
        caseTypeDO.setTypeName(caseTypeBO.getTypeName());
        caseTypeDO.setTypeNameEn(caseTypeBO.getTypeNameEn());
        caseTypeDO.setTypeImage(caseTypeBO.getTypeImage());
        caseTypeDO.setTypeIcon(caseTypeBO.getTypeIcon());
        return caseTypeDO;
    }

    public static CaseTypeVO convertBTV(CaseTypeBO caseTypeBO) {
        CaseTypeVO caseTypeVO = new CaseTypeVO();
        caseTypeVO.setType(caseTypeBO.getType());
        caseTypeVO.setTypeName(caseTypeBO.getTypeName());
        caseTypeVO.setTypeNameEn(caseTypeBO.getTypeNameEn());
        caseTypeVO.setTypeImage(caseTypeBO.getTypeImage());
        caseTypeVO.setTypeIcon(caseTypeBO.getTypeIcon());
        return caseTypeVO;
    }
}
