package com.aimeow.iteastyle.domain.query;

import com.aimeow.iteastyle.tools.domain.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created on 2018/11/6 9:09 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class AddressQuery extends BaseQuery {
    private String userId;
    private Boolean isDefault;
}
