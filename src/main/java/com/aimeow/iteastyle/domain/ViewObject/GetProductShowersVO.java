package com.aimeow.iteastyle.domain.ViewObject;

import lombok.Data;

import java.util.List;

@Data
public class GetProductShowersVO {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private List<CaseVO> cases;
}
