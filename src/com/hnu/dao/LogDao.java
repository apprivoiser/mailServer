package com.hnu.dao;

import java.util.List;

import com.hnu.pojo.Log;

public interface LogDao {
	public int insert(Log log) throws Exception;
	List<Log> logShowDao();
}
