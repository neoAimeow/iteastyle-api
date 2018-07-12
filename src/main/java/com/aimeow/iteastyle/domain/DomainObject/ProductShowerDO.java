package com.aimeow.iteastyle.domain.DomainObject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ProductShowerDO extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1434062932553096110L;
    @Id
    private String title;
    private Integer type;
    private List<String> imageArr;
    private String content;
}
