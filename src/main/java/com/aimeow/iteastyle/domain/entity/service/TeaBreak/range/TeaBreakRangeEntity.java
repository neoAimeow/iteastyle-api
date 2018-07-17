package com.aimeow.iteastyle.domain.entity.service.TeaBreak.range;

import lombok.Data;

import java.util.List;

@Data
public class TeaBreakRangeEntity {
    private String title;
    private String title_en;
    private List<TeaBreakRangeItemEntity> ranges;
}
