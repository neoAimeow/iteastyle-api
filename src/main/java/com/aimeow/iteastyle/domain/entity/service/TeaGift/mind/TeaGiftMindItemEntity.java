package com.aimeow.iteastyle.domain.entity.service.TeaGift.mind;

import lombok.Data;

import java.util.List;

@Data
public class TeaGiftMindItemEntity {
    private String itemTitle;
    private String itemImageUrl;
    private String itemContent;
    private List<TeaGiftMindItemElementEntity> elements;
}
