package com.aimeow.iteastyle.base.tools;

import com.aimeow.iteastyle.base.domain.BaseEntity;

public interface CommonData {
    <T extends BaseEntity> T getData(Class<T> cls) throws Exception;
    <T extends BaseEntity> Boolean edit(T t, Class<T> cls) throws Exception;
}
