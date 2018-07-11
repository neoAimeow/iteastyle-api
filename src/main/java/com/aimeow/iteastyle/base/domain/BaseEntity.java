package com.aimeow.iteastyle.base.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class BaseEntity {
    @Id
    private String id;
    private Date gmtCreate;
    private Date gmtModified;
}
