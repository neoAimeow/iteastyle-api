package com.aimeow.iteastyle.domain.query;

import lombok.Data;

@Data
public class BaseQuery {
    private Integer startRow;
    private Integer page;
    private Integer pageSize;
    private Integer limit;
}
