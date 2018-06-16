package com.aimeow.iteastyle.domain;

import java.util.Date;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PostDO {
    @Id
    private String id;
    private Integer status;
    private String title;
    private Date gmtCreate;
    private Date gmtModified;
    private String content;
}
