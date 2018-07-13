package com.aimeow.iteastyle.domain.ViewObject.Case;

import java.util.List;

import com.aimeow.iteastyle.domain.entity.CaseEntity;
import com.aimeow.iteastyle.domain.entity.CaseTypeEntity;
import lombok.Data;

@Data
public class CasesInTypeVO {
    private CaseTypeEntity caseType;
    private List<CaseEntity> cases;
}
