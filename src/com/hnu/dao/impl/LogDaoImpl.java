package com.hnu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnu.dao.LogDao;
import com.hnu.pojo.Log;
import com.hnu.pojo.User;
import com.hnu.utils.DBConnection;

public class LogDaoImpl implements LogDao{

	@Override
	public int insert(Log log) throws Exception {
		//声明jdbc对象
		DBConnection conn=null;
		PreparedStatement ps=null;
		//声明变量
		int index=-1;
		try {
			//加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailsystem","root", "151819");
			conn = new DBConnection();
			//创建SQL命令
			String sql="insert into ms_log values(default,?,?,?)";
			//创建SQL命令对象
			ps=conn.getConnection().prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,log.getOperation());
			ps.setTimestamp(2, log.getDate());
			ps.setString(3, log.getState());
			//执行
			index=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭资源
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.close();
		}
		//返回结果
		return index;
	
	}

	@Override
	public List<Log> logShowDao() {
		//声明jdbc对象
				DBConnection conn=null;
						PreparedStatement ps=null;
						ResultSet rs=null;
						//声明变量
						List<Log> lu=null;
						try {
							//加载驱动
//							Class.forName("com.mysql.jdbc.Driver");
							//获取连接
//							conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailsystem","root", "151819");
							conn = new DBConnection();
							//创建sql命令
							String sql="select * from ms_log";
							//创建sql命令对象
							ps=conn.getConnection().prepareStatement(sql);
							//执行sql
							rs=ps.executeQuery();
							//给集合赋值
							lu=new ArrayList<Log>();
							//遍历结果
								while(rs.next()){
									//给变量赋值
									Log u=new Log();
									u.setId(rs.getInt("id"));
									u.setOperation(rs.getString("operation"));
									u.setDate(rs.getTimestamp("date"));
									u.setState(rs.getString("state"));
									//将对象存储到集合中
									lu.add(u);
								}
							
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//关闭资源
							try {
								rs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								ps.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							conn.close();
						}
						
						
						//返回结果
						return lu;
	}

}
