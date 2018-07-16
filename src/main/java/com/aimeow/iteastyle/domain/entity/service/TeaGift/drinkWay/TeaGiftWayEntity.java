package com.aimeow.iteastyle.domain.entity.service.TeaGift.drinkWay;

import lombok.Data;

import java.util.List;

@Data
public class TeaGiftWayEntity {
    private String title;
    private String title_en;
    private String imageUrl;
    private List<TeaGiftWayItemEntity> ways;
}
