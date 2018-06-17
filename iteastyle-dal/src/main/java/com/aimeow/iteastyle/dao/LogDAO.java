package com.aimeow.iteastyle.dao;

import com.aimeow.iteastyle.domain.LogDO;
import com.aimeow.iteastyle.domain.query.LogQuery;

public interface LogDAO {
    LogDO queryLogs(
            LogQuery query
    ) throws Exception;
    Boolean record(
            LogDO logDO) throws Exception;
    Boolean removeRecord(
            String logId) throws Exception;
    Boolean clearRecord() throws Exception;
}
