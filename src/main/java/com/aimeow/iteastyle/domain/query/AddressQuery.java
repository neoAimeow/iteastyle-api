package com.aimeow.iteastyle.domain.query;

import com.aimeow.domain.BaseQuery;
import lombok.Data;

/**
 * Created on 2018/11/6 9:09 PM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Data
public class AddressQuery extends BaseQuery {
    private String userId;
    private Boolean isDefault;
}
