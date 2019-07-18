package com.aimeow.iteastyle.tools.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class BaseEntity {
    private String id;
    private Date gmtCreate;
    private Date gmtModified;
}
