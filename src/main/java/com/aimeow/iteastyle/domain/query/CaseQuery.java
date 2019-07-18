package com.aimeow.iteastyle.domain.query;

import com.aimeow.iteastyle.tools.domain.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CaseQuery extends BaseQuery {
    private Integer type;
}
