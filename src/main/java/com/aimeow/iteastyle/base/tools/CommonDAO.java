package com.aimeow.iteastyle.base.tools;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import com.aimeow.iteastyle.base.domain.BaseQuery;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;


public interface CommonDAO {
    <TD extends BaseEntity> TD queryById(String id , Class<TD> cls) throws Exception;
    <TD extends BaseEntity> List<TD> queryByParam(Map<String , String> param, Class<TD> cls) throws Exception;
    <TD extends BaseEntity,TQ extends BaseQuery> List<TD> queryList(TQ query, Class<TD> cls) throws Exception;
    <TD extends BaseEntity,TQ extends BaseQuery> Long count(TQ query, Class<TD> cls) throws Exception;
    <TD extends BaseEntity> Boolean create(TD domain) throws Exception;
    <TD extends BaseEntity> Boolean update(TD domain , Class<TD> cls) throws Exception;
    <TD extends BaseEntity> Boolean delete(String id , Class<TD> cls) throws Exception;
    <TD extends BaseEntity> Boolean clear(Class<TD> cls) throws Exception;
}
