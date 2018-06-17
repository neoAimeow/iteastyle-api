package com.aimeow.iteastyle.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class LogDO {
    @Id
    private String id;
    private String content;
    private String operator;
    private Date gmtCreate;
    private Date gmtModified;
}
