package com.hnu.server.pop3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.List;

import com.hnu.dao.LogDao;
import com.hnu.dao.MailDao;
import com.hnu.dao.UserDao;
import com.hnu.dao.impl.LogDaoImpl;
import com.hnu.dao.impl.MailDaoImpl;
import com.hnu.dao.impl.UserDaoImpl;
import com.hnu.pojo.Log;
import com.hnu.pojo.Mail;
import com.hnu.pojo.User;
import com.hnu.server.queue.userMailQueue;


public class POP3ServerSocketThread extends Thread {

    private Socket socket;

    public POP3ServerSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader in = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
        	is = socket.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr);
            
            String message=null;
            String uname=null;
            String pwd=null;
            int cnt=0;
            while ((message = in.readLine()) != null) {
                System.out.println(message);
                ++cnt;
                if(cnt==1) {
                	uname=message;
                }
                else {
                	pwd=message;
                }
            }
            socket.shutdownInput();
        	
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            
            Log log=new Log();
            log.setDate(new Timestamp(System.currentTimeMillis()));
            if(cnt==2)
            {
            	UserDao userDao=new UserDaoImpl();
                User u= userDao.checkUserLoginDao(uname,pwd);
                if(u!=null)
                {
                	pw.write("1");
                	log.setOperation("用户"+uname+"登录成功");
                	log.setState("1");
                }
                else
                {
                	pw.write("0");
                	log.setOperation("用户"+uname+"登录失败");
                	log.setState("0");
                }
            }
            else
            {
            	UserDao userDao=new UserDaoImpl();
                int uid = userDao.queryByAccount(uname);
                MailDao mailDao=new MailDaoImpl();
                List<Mail> lu=mailDao.mailShowByUnameDao(uname);
            	message=null;
            	if(lu.size()!=0)
                {
                	for(Mail mail:lu) {
                		if(message==null){
                			message = mail.getFrom_user()+"\r\n"+
       	   						 mail.getTo_user()+"\r\n"+
       	   						 mail.getSubject()+"\r\n"+
       	   						 mail.getDate().toString()+"\r\n"+
       	   						 mail.getContent()+"\r\n"+
       	   						 "ExOxF"+"\r\n";
                		}else {
                			message += mail.getFrom_user()+"\r\n"+
       	   						 mail.getTo_user()+"\r\n"+
       	   						 mail.getSubject()+"\r\n"+
       	   						 mail.getDate().toString()+"\r\n"+
       	   						 mail.getContent()+"\r\n"+
       	   						 "ExOxF"+"\r\n";
                		}
                	}
                	System.out.println(message);
            		pw.write(message);
            		log.setOperation("用户"+uname+"接收邮件成功");
                	log.setState("1");
                }else{
                  	pw.write("0");
                  	log.setOperation("用户"+uname+"接收邮件失败");
                	log.setState("0");
                }
            }
            LogDao logDao = new LogDaoImpl();
            logDao.insert(log);
            pw.flush();
            socket.shutdownOutput();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
				if (pw != null) {
				    pw.close();
				}
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}