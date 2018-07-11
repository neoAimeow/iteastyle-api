package com.aimeow.iteastyle.domain.DomainObject;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ProductShowerDO extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8792227631525047292L;
    private String title;
    private List<String> imageArr;
    private String content;
}
