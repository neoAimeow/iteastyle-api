package com.aimeow.iteastyle.domain.query;

import com.aimeow.iteastyle.base.domain.BaseQuery;
import lombok.Data;

@Data
public class CaseQuery extends BaseQuery {
    private String caseId;
    private Integer type;
}
