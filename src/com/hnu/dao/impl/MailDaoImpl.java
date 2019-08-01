package com.hnu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnu.dao.MailDao;
import com.hnu.pojo.Mail;
import com.hnu.pojo.User;
import com.hnu.server.port.PORT;
import com.hnu.utils.DBConnection;;

public class MailDaoImpl implements MailDao{

	@Override
	public int insert(Mail mail) throws Exception {
		// TODO 自动生成的方法存根
		DBConnection con = null;
        PreparedStatement pstm = null;
        String sql=null;
        ResultSet rs = null;
        int size=0;
        try
        {
            con = new DBConnection();            
            sql = "select count(*) from ms_mail";
            pstm = con.getConnection().prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                size=rs.getInt(1);
            }
            if (pstm != null)
            {
                pstm.close();
            }
            System.out.println("当前邮箱容量: "+size);
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("插入数据操作异常:"+sql);
        } finally
        {
            if (con != null)
            {
                con.close();
            }
            if(size>=PORT.mailboxSize)
            {
            	System.out.println("邮箱已满: "+size);
            	return 0;
            }
        }
        
        
        try
        {
        	con = new DBConnection();
        	sql = "insert into ms_mail(from_user,to_user,subject,date,content) values(?,?,?,?,?)";
            pstm = con.getConnection().prepareStatement(sql);
            pstm.setString(1, mail.getFrom_user());
            pstm.setString(2, mail.getTo_user());
            pstm.setString(3, mail.getSubject());
            pstm.setTimestamp(4, mail.getDate());
            pstm.setString(5, mail.getContent());
            pstm.executeUpdate();
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("插入数据操作异常");
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
        
        rs = null;
        try
        {
            con = new DBConnection();            
            sql = "select max(id) from ms_mail where from_user=?";
            pstm = con.getConnection().prepareStatement(sql);
            pstm.setString(1, mail.getFrom_user());
//            pstm.setTimestamp(2, mail.getDate());
            rs = pstm.executeQuery();
            while(rs.next())
            {
                mail.setId(rs.getInt(1));
            }
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("获取id异常   sql:"+sql);
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
        return mail.getId(); 
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO 自动生成的方法存根
		DBConnection con = null;
        PreparedStatement pstm = null;
        String sql = "delete from ms_mail where id=?";

        try
        {
            con = new DBConnection();
            pstm = con.getConnection().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("删除数据操作异常");
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
	}

	@Override
	public Mail queryById(int id) throws Exception {
		// TODO 自动生成的方法存根
		DBConnection con = null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        Mail mail=null;
        String sql = "select * from ms_mail where id=?";

        try
        {
            //获取连接
            con = new DBConnection();
            //预处理语句
            pstm = con.getConnection().prepareStatement(sql);
            //设置参数
            pstm.setInt(1, id);
            //执行查询
            rs = pstm.executeQuery();
            //获取结果
            while(rs.next())
            {
                mail = new Mail();
                mail.setId(rs.getInt(1));
                mail.setFrom_user(rs.getString(2));
                mail.setTo_user(rs.getString(3));
                mail.setSubject(rs.getString(4));
                mail.setDate(rs.getTimestamp(5));
                mail.setContent(rs.getString(6));
            }
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("查询数据操作异常   sql:"+sql);
            return null;
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
        return mail;
	}

	@Override
	public List<Mail> mailShowByUnameDao(String uname) {
		// TODO Auto-generated method stub
		DBConnection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<Mail> lu=null;
		try {
			conn = new DBConnection();
			//创建sql命令
			String sql="select * from ms_mail where to_user=?";
			//创建sql命令对象
			ps=conn.getConnection().prepareStatement(sql);
			ps.setString(1, uname);
			//执行sql
			rs=ps.executeQuery();
			//给集合赋值
			lu=new ArrayList<Mail>();
			//遍历结果
				while(rs.next()){
					//给变量赋值
	                Mail mail = new Mail();
	                mail.setId(rs.getInt(1));
	                mail.setFrom_user(rs.getString(2));
	                mail.setTo_user(rs.getString(3));
	                mail.setSubject(rs.getString(4));
	                mail.setDate(rs.getTimestamp(5));
	                mail.setContent(rs.getString(6));
					//将对象存储到集合中
					lu.add(mail);
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
