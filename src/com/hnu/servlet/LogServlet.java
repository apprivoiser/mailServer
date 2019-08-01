package com.hnu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hnu.pojo.Log;
import com.hnu.pojo.User;
import com.hnu.server.switches.MyThread;
import com.hnu.service.LogService;
import com.hnu.service.UserService;
import com.hnu.service.impl.LogServiceImpl;
import com.hnu.service.impl.UserServiceImpl;

public class LogServlet extends HttpServlet {
	Logger logger =Logger.getLogger(ServiceServlet.class);
	//获取service层对象
	LogService us=new LogServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取操做符
		String oper=req.getParameter("oper");
		if("show".equals(oper)){
			serviceShow(req,resp);
		}else{
			logger.debug("没有找到对应的操作符："+oper);
		}
	}
	//显示所有的用户信息
	private void serviceShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
		List<Log> lu=us.logShowService();
		System.out.println(lu.size());
		//判断
		if(lu!=null){
			//将查询的用户数据存储到request对象
			req.setAttribute("lu",lu);
			//请求转发
			req.getRequestDispatcher("/log/showLog.jsp").forward(req, resp);
			return;
		}
		
		return;
		
	}
}
