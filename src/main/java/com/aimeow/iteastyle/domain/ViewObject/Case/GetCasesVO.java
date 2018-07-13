package com.aimeow.iteastyle.domain.ViewObject.Case;

import lombok.Data;

@Data
public class GetCasesVO {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private CasesInTypeVO model;
}
