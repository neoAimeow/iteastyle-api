package com.aimeow.iteastyle.domain.entity.service;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
//已经废弃
@EqualsAndHashCode(callSuper=true)
public class TeaPerformEntity extends BaseEntity {
    private String iconImageUrl;
    private String title;
    private String title_en;
    private List<String> imageUrls;
}
