package com.aimeow.iteastyle.tools.domain;

import java.util.List;

import lombok.Data;

@Data
public class BaseGetList<T> {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private T items;
}
