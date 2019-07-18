package com.aimeow.iteastyle.tools.tools;


import com.aimeow.iteastyle.tools.domain.BaseEntity;

public interface CommonData {
    <T extends BaseEntity> T getData(Class<T> cls) throws Exception;
    <T extends BaseEntity> Boolean edit(T t, Class<T> cls) throws Exception;
}
