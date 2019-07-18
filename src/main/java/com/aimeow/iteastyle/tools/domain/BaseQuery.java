package com.aimeow.iteastyle.tools.domain;

import lombok.Data;

@Data
public class BaseQuery {
    private Integer page = 1;
    private Integer pageSize = 10;
}
