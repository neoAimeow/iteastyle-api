package com.aimeow.iteastyle.tools.tools;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import com.aimeow.iteastyle.tools.domain.BaseQuery;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;


public interface CommonDAO {
    <TD extends BaseEntity> TD queryById(String id , Class<TD> cls) throws Exception;
    <TD extends BaseEntity> List<TD> queryByParam(Map<String , Object> param, Class<TD> cls , String orderBy , Boolean isDESC) throws Exception;
    <TD extends BaseEntity,TQ extends BaseQuery> List<TD> queryList(TQ query, Class<TD> cls , String orderBy , Boolean isDESC) throws Exception;
    <TD extends BaseEntity> List<TD> queryAllList(Class<TD> cls , String orderBy , Boolean isDESC) throws Exception;
    <TD extends BaseEntity,TQ extends BaseQuery> Long count(TQ query, Class<TD> cls) throws Exception;
    <TD extends BaseEntity> Boolean create(TD domain) throws Exception;
    <TD extends BaseEntity> Boolean updateById(TD domain , Class<TD> cls) throws Exception;
    <TD extends BaseEntity> Boolean update(TD domain , Class<TD> cls) throws Exception;
    <TD extends BaseEntity> Boolean delete(String id , Class<TD> cls) throws Exception;
    <TD extends BaseEntity> Boolean clear(Class<TD> cls) throws Exception;
}
