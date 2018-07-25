package com.aimeow.iteastyle.domain.query;

import com.aimeow.domain.BaseQuery;
import lombok.Data;

@Data
public class PostQuery extends BaseQuery {
    private String postId;
    private Integer status;
}
