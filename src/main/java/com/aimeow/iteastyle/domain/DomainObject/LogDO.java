package com.aimeow.iteastyle.domain.DomainObject;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
public class LogDO extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3581743765991899540L;
    private String content;
    private String operator;
}
