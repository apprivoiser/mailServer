package com.hnu.service.impl;

import java.util.List;

import com.hnu.dao.LogDao;
import com.hnu.dao.UserDao;
import com.hnu.dao.impl.LogDaoImpl;
import com.hnu.dao.impl.UserDaoImpl;
import com.hnu.pojo.Log;
import com.hnu.service.LogService;

public class LogServiceImpl implements LogService{
	LogDao ld=new LogDaoImpl();
	@Override
	public int logAddService(Log log) throws Exception  {
		return ld.insert(log);
	}

	@Override
	public List<Log> logShowService() {
		return ld.logShowDao();
	}

}
