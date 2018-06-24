package com.aimeow.iteastyle.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ProductShowerDO implements Serializable {
    private static final long serialVersionUID = 8792227631525047292L;
    @Id
    private String id;
    private String title;
    private List<String> imageArr;
    private String content;
    private Date gmtCreate;
    private Date gmtModified;
}
