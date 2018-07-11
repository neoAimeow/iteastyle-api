package com.aimeow.iteastyle.domain.DomainObject;

import java.io.Serializable;
import java.util.Date;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PostDO extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4600719531243418227L;
    private Integer status;
    private String title;
    private String content;
}
