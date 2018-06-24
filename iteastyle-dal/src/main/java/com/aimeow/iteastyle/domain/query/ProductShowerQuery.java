package com.aimeow.iteastyle.domain.query;

import lombok.Data;

@Data
public class ProductShowerQuery extends BaseQuery {
    private String productShowerId;
    private Integer status;
}
