package com.hnu.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hnu.dao.UserDao;
import com.hnu.dao.impl.UserDaoImpl;
import com.hnu.pojo.Mail;
import com.hnu.pojo.User;
import com.hnu.server.queue.userMailQueue;
import com.hnu.service.MailService;
import com.hnu.service.UserService;
import com.hnu.service.impl.MailServiceImpl;
import com.hnu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class MailServlet
 */
public class MailServlet extends HttpServlet {
	//声明日志对象
	Logger logger =Logger.getLogger(UserServlet.class);
	//获取service层对象
	MailService ms=new MailServiceImpl();
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取操做符
//		System.out.println("#####"+req.getParameter("id"));
//		System.out.println("#####"+req.getParameter("oper"));
		String oper=req.getParameter("oper");
		if("login".equals(oper)){
			//调用登录处理方法
//			checkUserLogin(req,resp);
		}else if("out".equals(oper)){
			//调用退出功能
//			userOut(req,resp);
		}else if("pwd".equals(oper)){
			//调用密码修改功能
//			userChangePwd(req,resp);	
		}else if("show".equals(oper)){
			//调用显示所有用户功能
			mailShow(req,resp);
		}else if("send".equals(oper)){
			//调用注册功能
			try {
				sendMail(req,resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			logger.debug("没有找到对应的操作符："+oper);
		}
	}
	//注册用户
	private void sendMail(HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
		//获取请求信息
			String subject=req.getParameter("subject");
			System.out.println("*********"+subject);
			HttpSession hs=req.getSession();
			String from_user = ((User)hs.getAttribute("user")).getUname();
			System.out.println("*********"+from_user);
			String to_user=req.getParameter("to_user");
			System.out.println("*********"+to_user);
			String content=req.getParameter("content");
			System.out.println("*********"+content);
	 		Date date = new Date();
	 		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 		String time = df.format(date);
	 		System.out.println("*********"+time);
//	 		Timestamp now = time.;
	 		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	 		Timestamp ts = new Timestamp(format.parse(time).getTime());
//			int type=req.getParameter("type")!=""?Integer.parseInt(req.getParameter("type")):0;
			System.out.println(subject+":"+to_user+":"+content);
//			User u=new User(0, uname, pwd, type);
			Mail mail = new Mail(0, from_user,to_user,subject,ts,content);
			System.out.println("*********"+mail.toString());
		//处理请求信息
			//调用业务层处理
			int index=ms.insertService(mail);
		//响应处理结果
			if(index>0){
				//获取session
				
				hs.setAttribute("reg", "true");
				//重定向
				resp.sendRedirect("/mg/index.jsp");
			}
		
	}
	//显示所有的用户信息
	private void mailShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
			//调用service
			List<User> lu=us.userShowService();
			//判断
			if(lu!=null){
				//将查询的用户数据存储到request对象
				req.setAttribute("lu",lu);
				//请求转发
		req.getRequestDispatcher("/mail/sendMail.jsp").forward(req, resp);
		return;
			}
	}
//	//用户修改密码
//	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		//获取数据
//			String newPwd=req.getParameter("newPwd");
//			//从session中获取用户信息
//			User u=(User)req.getSession().getAttribute("user");
//			int uid=u.getUid();
//		//处理请求
//			//调用service处理
//			int index=us.userChangePwdService(newPwd,uid);
//			if(index>0){
//				//获取session对象
//				HttpSession hs=req.getSession();
//				hs.setAttribute("pwd","true");
//				//重定向到登录页面
//				resp.sendRedirect("/mg/login.jsp");
//			}
//	}
//	//用户退出
//	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		//获取session对象
//		HttpSession hs=req.getSession();
//		//强制销毁session
//		hs.invalidate();
//		//重定向到登录页面
//		resp.sendRedirect("/mg/login.jsp");
//	}
//	//处理登录
//	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//				//获取请求信息
//				String uname=req.getParameter("uname");
//				String pwd=req.getParameter("pwd");
//				//处理请求信息
//					//校验
//					User u=us.checkUserLoginService(uname, pwd);
//					if(u!=null){
//						//获取session对象
//						HttpSession hs=req.getSession();
//						//将用户数据存储到session中
//						hs.setAttribute("user", u);
//						//重定向
//						resp.sendRedirect("/mg/main/main.jsp");
//						return;
//					}else{
//						//添加标识符到request中
//						req.setAttribute("flag",0);
//						//请求转发
//						req.getRequestDispatcher("/login.jsp").forward(req, resp);
//						return;
//					}
//				//响应处理结果
//					//直接响应
//					//请求转发
//					
					
//	}
	
	
}

