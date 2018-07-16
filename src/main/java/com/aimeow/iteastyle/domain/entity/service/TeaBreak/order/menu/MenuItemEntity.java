package com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu;

import lombok.Data;

import java.util.List;

@Data
public class MenuItemEntity {
    private String title;
    private String icon;
    private List<String> desserts;
}
