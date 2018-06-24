package com.aimeow.iteastyle.domain;

import lombok.Data;

import java.util.List;

@Data
public class GetCasesVO {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private List<CaseVO> cases;
}
