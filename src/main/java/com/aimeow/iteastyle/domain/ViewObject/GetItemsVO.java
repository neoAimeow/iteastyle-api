package com.aimeow.iteastyle.domain.ViewObject;

import java.util.List;

import com.aimeow.iteastyle.domain.entity.PostEntity;
import lombok.Data;

@Data
public class GetItemsVO<T> {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private T items;
}
