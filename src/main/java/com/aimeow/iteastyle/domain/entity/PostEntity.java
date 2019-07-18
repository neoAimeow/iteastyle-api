package com.aimeow.iteastyle.domain.entity;

import java.io.Serializable;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PostEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4600719531243418227L;
    private Integer status;
    private String title;
    private String content;
    private String summary;
    private String imageUrl;
}
