package com.aimeow.iteastyle.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PostDO implements Serializable {
    private static final long serialVersionUID = -4600719531243418227L;
    @Id
    private String id;
    private Integer status;
    private String title;
    private Date gmtCreate;
    private Date gmtModified;
    private String content;
}
