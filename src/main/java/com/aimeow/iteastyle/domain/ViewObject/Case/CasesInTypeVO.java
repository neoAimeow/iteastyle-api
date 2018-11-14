package com.aimeow.iteastyle.domain.ViewObject.Case;

import java.util.List;

import com.aimeow.iteastyle.domain.entity.CaseEntity;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class CasesInTypeVO {
    private JSONObject caseType;
    private List<CaseEntity> cases;
}
