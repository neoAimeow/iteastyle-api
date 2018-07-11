package com.aimeow.iteastyle.domain.ViewObject;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class LogVO extends BaseEntity {
    private String content;
    private String operator;
}
