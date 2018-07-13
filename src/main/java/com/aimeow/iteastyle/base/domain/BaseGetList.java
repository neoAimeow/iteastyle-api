package com.aimeow.iteastyle.base.domain;

import java.util.List;

import com.aimeow.iteastyle.domain.entity.PostEntity;
import lombok.Data;

@Data
public class BaseGetList<T> {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private T items;
}
