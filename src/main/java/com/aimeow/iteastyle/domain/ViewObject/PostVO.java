package com.aimeow.iteastyle.domain.ViewObject;

import java.util.Date;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

@Data
public class PostVO extends BaseEntity {
    private Integer status;
    private String title;
    private String content;
    private String imageUrl;
}
