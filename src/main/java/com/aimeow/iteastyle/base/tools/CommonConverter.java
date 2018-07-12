package com.aimeow.iteastyle.base.tools;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import com.alibaba.fastjson.JSONObject;

public class CommonConverter {
    public static <T1 extends BaseEntity , T2 extends BaseEntity> T1 convert(T2 t2 , Class<T1> cls) {
        System.out.println(t2.getId());
        return JSONObject.parseObject(JSONObject.toJSONString(t2),cls);
    }
}
