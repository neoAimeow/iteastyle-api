package com.aimeow.iteastyle.manager;

import com.aimeow.iteastyle.domain.LogBO;
import com.aimeow.iteastyle.domain.Result;

import java.util.List;

public interface LogManager {
    Result<List<LogBO>> queryLogs() throws Exception;
    Result<Boolean> record() throws Exception;
    Result<Boolean> removeLogById(String logId) throws Exception;
    Result<Boolean> clearLogs() throws Exception;
}
