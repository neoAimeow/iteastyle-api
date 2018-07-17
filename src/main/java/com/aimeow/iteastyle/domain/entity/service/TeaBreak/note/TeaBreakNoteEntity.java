package com.aimeow.iteastyle.domain.entity.service.TeaBreak.note;

import lombok.Data;

import java.util.List;

@Data
public class TeaBreakNoteEntity {
    private String title;
    private String title_en;
    private List<String> notes;
}
