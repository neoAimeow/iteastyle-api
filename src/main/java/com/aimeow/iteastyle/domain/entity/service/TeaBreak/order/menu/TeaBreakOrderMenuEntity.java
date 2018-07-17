package com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu;

import lombok.Data;

import java.util.List;

@Data
public class TeaBreakOrderMenuEntity {
    private String title;
    private List<MenuEntity> menus;
}
