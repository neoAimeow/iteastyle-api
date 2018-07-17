package com.aimeow.iteastyle.domain.entity.service.TeaBreak.process;

import lombok.Data;

import java.util.List;

@Data
public class TeaBreakProcessEntity {
    private String title;
    private String title_en;
    private List<TeaBreakProcessItemEntity> processes;
}
