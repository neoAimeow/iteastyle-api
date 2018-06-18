package com.aimeow.iteastyle.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CaseDO {
    @Id
    private String id;
    private String title;
    private Integer type;
    private List<String> imageArr;
    private Date gmtCreate;
    private Date gmtModified;
}
