package com.hnu.service;

import java.util.List;

import com.hnu.pojo.Log;

public interface LogService {
	int logAddService(Log log) throws Exception;
	List<Log> logShowService();
}
