package com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class MenuEntity extends BaseEntity {
    private Integer sort;
    private String title;
    private List<MenuItemEntity> items;
}
