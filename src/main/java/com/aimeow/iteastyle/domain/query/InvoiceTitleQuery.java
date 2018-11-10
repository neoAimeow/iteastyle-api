package com.aimeow.iteastyle.domain.query;

import com.aimeow.domain.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class InvoiceTitleQuery extends BaseQuery {
    private String userId;
    private Boolean isDefault;
}
