package com.aimeow.iteastyle.manager.impl;

import com.aimeow.iteastyle.converter.LogConverter;
import com.aimeow.iteastyle.dao.LogDAO;
import com.aimeow.iteastyle.domain.LogBO;
import com.aimeow.iteastyle.domain.LogDO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.query.LogQuery;
import com.aimeow.iteastyle.manager.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LogManagerImpl implements LogManager {
    @Autowired private LogDAO logDAO;

    @Override
    public Result<List<LogBO>> queryLogs(
            Integer page , Integer pageSize) throws Exception {
        Result<List<LogBO>> result = new Result<>();
        List<LogBO> logBOS = new ArrayList<>();
        LogQuery query = new LogQuery();
        query.setPage((page==null || page==0)?1:page);
        query.setPageSize((pageSize==null || pageSize==0)?10:pageSize);
        query.setStartRow((page-1) * pageSize);
        List<LogDO> logDOS = logDAO.queryLogs(query);
        logDOS.iterator().forEachRemaining(
                obj-> {
                    logBOS.add(LogConverter.convertDTB(obj));
                }
        );
        result.setModel(logBOS);
        return result;
    }

    @Override
    public Result<Boolean> record(LogBO logBO) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(logDAO.record(LogConverter.convertBTD(logBO)));
        return result;
    }

    @Override
    public Result<Boolean> clearLogs() throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(logDAO.clearRecord());
        return result;
    }

    @Override
    public Result<Boolean> removeLogById(String logId) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(logDAO.removeRecord(logId));
        return result;
    }
}
