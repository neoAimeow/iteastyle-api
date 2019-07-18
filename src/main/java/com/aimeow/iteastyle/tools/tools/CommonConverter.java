package com.aimeow.iteastyle.tools.tools;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import com.alibaba.fastjson.JSONObject;

public class CommonConverter {
    public static <T1 extends BaseEntity, T2 extends BaseEntity> T1 convert(T2 t2 , Class<T1> cls) {
        return JSONObject.parseObject(JSONObject.toJSONString(t2),cls);
    }
}
