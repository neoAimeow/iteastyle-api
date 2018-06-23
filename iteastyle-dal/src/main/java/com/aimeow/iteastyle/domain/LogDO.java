package com.aimeow.iteastyle.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
public class LogDO implements Serializable {

    private static final long serialVersionUID = -3581743765991899540L;
    @Id
    private String id;
    private String content;
    private String operator;
    private Date gmtCreate;
    private Date gmtModified;
}
