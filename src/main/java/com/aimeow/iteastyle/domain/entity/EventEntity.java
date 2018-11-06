package com.aimeow.iteastyle.domain.entity;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created on 2018/11/6 8:57 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EventEntity extends BaseEntity {
    private String title;
    private String imageUrl;
    private String content;
}
