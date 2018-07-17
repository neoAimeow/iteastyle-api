package com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.way;

import lombok.Data;

import java.util.List;

@Data
public class TeaBreakOrderWayEntity {
    private String title;
    private List<TeaBreakOrderWayItemEntity> items;
}