package com.aimeow.iteastyle.domain;

import lombok.Data;

import java.util.List;

@Data
public class GetProductShowersVO {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private String headerImageUrl;
    private List<ProductShowerVO> products;
}
