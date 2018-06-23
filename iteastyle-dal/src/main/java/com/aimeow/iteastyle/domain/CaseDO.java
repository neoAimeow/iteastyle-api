package com.aimeow.iteastyle.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CaseDO implements Serializable {
    private static final long serialVersionUID = -1434062932553096110L;
    @Id
    private String id;
    private String title;
    private Integer type;
    private Integer status;
    private List<String> imageArr;
    private Date gmtCreate;
    private Date gmtModified;
}
