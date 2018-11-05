package com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class MenuEntity extends BaseEntity {
    private Integer sort;
    private String title;
    private List<MenuItemEntity> items;
}
