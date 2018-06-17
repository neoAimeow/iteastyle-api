package com.aimeow.iteastyle.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class ProductShowerDO {
    @Id
    private String id;

    private Date gmtCreate;
    private Date gmtModified;
}
