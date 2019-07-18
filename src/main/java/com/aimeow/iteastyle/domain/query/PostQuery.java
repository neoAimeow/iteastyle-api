package com.aimeow.iteastyle.domain.query;

import com.aimeow.iteastyle.tools.domain.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PostQuery extends BaseQuery {
    private String postId;
    private Integer status;
}
