package com.aimeow.iteastyle.manager.impl;

import com.aimeow.iteastyle.dao.LogDAO;
import com.aimeow.iteastyle.domain.LogBO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.manager.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LogManagerImpl implements LogManager {
    @Autowired private LogDAO logDAO;

    @Override
    public Result<List<LogBO>> queryLogs() {

        return null;
    }

    @Override
    public Result<Boolean> record() {
        return null;
    }

    @Override
    public Result<Boolean> clearLogs() {
        return null;
    }

    @Override
    public Result<Boolean> removeLogById(String logId) {
        return null;
    }
}
