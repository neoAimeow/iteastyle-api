package com.aimeow.iteastyle.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
public class CaseBO {
    @Id
    private String id;
    private String title;
    private List<String> imageArr;
    private Date gmtCreate;
    private Date gmtModified;
}
