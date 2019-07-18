package com.aimeow.iteastyle.domain.entity;

import java.io.Serializable;
import java.util.List;
import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CaseEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1434062932553096110L;
    private String title;
    private Integer type;
    private String typeName;
    private List<String> imageArr;
    private String content;
}
