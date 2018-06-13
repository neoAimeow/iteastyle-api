package com.aimeow.iteastyle.dao;

import com.aimeow.iteastyle.domain.StaticDataDO;

public interface StaticDataDAO {
    StaticDataDO getStaticData() throws Exception;
    Boolean replaceStaticData(StaticDataDO staticDataDO) throws Exception;
}
