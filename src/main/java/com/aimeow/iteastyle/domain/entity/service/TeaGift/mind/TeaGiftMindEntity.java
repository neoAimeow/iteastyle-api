package com.aimeow.iteastyle.domain.entity.service.TeaGift.mind;

import lombok.Data;

import java.util.List;

@Data
public class TeaGiftMindEntity {
    private String title;
    private String title_en;
    private List<TeaGiftMindItemEntity> minds;
}
