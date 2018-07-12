package com.aimeow.iteastyle.domain.ViewObject.productShower;

import java.util.List;

import lombok.Data;

@Data
public class CasesInTypeVO {
    private CaseTypeVO caseType;
    private List<CaseBaseVO> cases;
}
