package com.hnu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnu.dao.UserDao;
import com.hnu.pojo.User;
import com.hnu.utils.DBConnection;

public class UserDaoImpl implements UserDao{
	//根据用户名和密码查询用户信息
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		//声明jdbc对象
		DBConnection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		User u=null;
		try {
			//加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailsystem","root", "151819");
			conn = new DBConnection();
			
			//创建sql命令
			String sql="select * from ms_user where uname=? and pwd=?";
			//创建sql命令对象
			ps=conn.getConnection().prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//执行sql
			rs=ps.executeQuery();
			//遍历结果
				while(rs.next()){
					//给变量赋值
					u=new User();
					u.setUid(rs.getInt("uid"));
					u.setUname(rs.getString("uname"));
					u.setPwd(rs.getString("pwd"));
					u.setType(rs.getInt("type"));
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
		return u;
	}
	//根据用户ID修改用户密码
	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		//声明jdbc对象
		DBConnection conn=null;
		PreparedStatement ps=null;
		//创建变量
		int index=-1;
		try {
			//加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailsystem","root", "151819");
			conn = new DBConnection();
			//创建SQL命令
			String sql="update ms_user set pwd=? where uid=?";
			//创建SQL命令对象
			ps=conn.getConnection().prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
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
	//获取所有的用户信息
	@Override
	public List<User> userShowDao() {
		//声明jdbc对象
		DBConnection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				//声明变量
				List<User> lu=null;
				try {
					//加载驱动
//					Class.forName("com.mysql.jdbc.Driver");
					//获取连接
//					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailsystem","root", "151819");
					conn = new DBConnection();
					//创建sql命令
					String sql="select * from ms_user";
					//创建sql命令对象
					ps=conn.getConnection().prepareStatement(sql);
					//执行sql
					rs=ps.executeQuery();
					//给集合赋值
					lu=new ArrayList<User>();
					//遍历结果
						while(rs.next()){
							//给变量赋值
							User u=new User();
							u.setUid(rs.getInt("uid"));
							u.setUname(rs.getString("uname"));
							u.setPwd(rs.getString("pwd"));
							u.setType(rs.getInt("type"));
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
	//通过uname获取用户信息
	public int queryByAccount(String uname) {
		//声明jdbc对象
				DBConnection conn=null;
						PreparedStatement ps=null;
						ResultSet rs=null;
						int ret=0;
						try {
							//加载驱动
//							Class.forName("com.mysql.jdbc.Driver");
							//获取连接
//							conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailsystem","root", "151819");
							conn = new DBConnection();
							//创建sql命令
							String sql="select * from ms_user where uname=?";
							//创建sql命令对象
							ps=conn.getConnection().prepareStatement(sql);
							ps.setString(1, uname);
							//执行sql
							rs=ps.executeQuery();
							//遍历结果
								while(rs.next()){
									ret=rs.getInt("uid");
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
						return ret;
	}
	//用户注册
	@Override
	public int userRegDao(User u) {
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
			String sql="insert into ms_user values(default,?,?,?)";
			//创建SQL命令对象
			ps=conn.getConnection().prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,u.getUname());
			ps.setString(2, u.getPwd());
			ps.setInt(3, u.getType());
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
	public int delete(int uid) {
		// TODO Auto-generated method stub
		//声明jdbc对象
		DBConnection conn=null;
				PreparedStatement ps=null;
				//声明变量
				int index=-1;
				try {
					//加载驱动
//					Class.forName("com.mysql.jdbc.Driver");
					//获取连接
//					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailsystem","root", "151819");
					conn = new DBConnection();
					//创建SQL命令
					String sql="delete from ms_user where uid=?";
					//创建SQL命令对象
					ps=conn.getConnection().prepareStatement(sql);
					//给占位符赋值
					ps.setInt(1,uid);

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
	public int update(User u) {
		// TODO Auto-generated method stub
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
			String sql="update ms_user set uname=?, pwd=?,type=? where uid=?";
			//创建SQL命令对象
			ps=conn.getConnection().prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,u.getUname());
			ps.setString(2,u.getPwd());
			ps.setInt(3,u.getType());
			ps.setInt(4,u.getUid());

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
	public int add(User u) {
		//声明jdbc对象
				DBConnection conn=null;
				PreparedStatement ps=null;
				//声明变量
				int index=-1;
				try {
					//加载驱动
//					Class.forName("com.mysql.jdbc.Driver");
					//获取连接
//					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailsystem","root", "151819");
					conn = new DBConnection();
					//创建SQL命令
					String sql="insert into ms_user values(default,?,?,?)";
					//创建SQL命令对象
					ps=conn.getConnection().prepareStatement(sql);
					//给占位符赋值
					ps.setString(1,u.getUname());
					ps.setString(2, u.getPwd());
					ps.setInt(3, u.getType());
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
	
}
