package com.aimeow.iteastyle.domain.entity.service.TeaBreak.order;

import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.menu.TeaBreakOrderMenuEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.way.TeaBreakOrderWayEntity;
import lombok.Data;

@Data
public class TeaBreakOrderEntity {
    private String title;
    private String title_en;
    private TeaBreakOrderWayEntity orderWay;
    private TeaBreakOrderMenuEntity menu;
}
