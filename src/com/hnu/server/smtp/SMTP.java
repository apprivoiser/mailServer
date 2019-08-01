package com.hnu.server.smtp;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hnu.dao.LogDao;
import com.hnu.dao.MailDao;
import com.hnu.dao.UserDao;
import com.hnu.dao.impl.LogDaoImpl;
import com.hnu.dao.impl.MailDaoImpl;
import com.hnu.dao.impl.UserDaoImpl;
import com.hnu.pojo.Log;
import com.hnu.pojo.User;
import com.hnu.server.port.PORT;
import com.hnu.server.queue.userMailQueue;

public class SMTP {

    private static ServerSocket SERVER_SOCKET =null;;
    
    private static String mailServer = "127.0.0.1";
    File file =new File("javaio-appendfile.txt");

    public static void SMTPOpen() throws Exception{
        try {
            SERVER_SOCKET = new ServerSocket(PORT.SMTPPORT);
            System.out.println("******SMTP服务器已启动，等待客户端连接*****");
            
            Log log=new Log();
            log.setOperation("******SMTP服务器已启动，等待客户端连接*****");
            log.setDate(new Timestamp(System.currentTimeMillis()));
            log.setState("1");
            LogDao logDao = new LogDaoImpl();
            logDao.insert(log);
            
            Socket socket = null;
//            int cnt=0;
            
//            UserDao userDao=new UserDaoImpl();
//            List<User> lu=userDao.userShowDao();
//            for(User u:lu) {
//            	userMailQueue.insert(u.getUid());
//            }
            
            while(!SERVER_SOCKET.isClosed()){
                //循环监听客户端的连接
                socket = SERVER_SOCKET.accept();
                Thread.sleep(10);
                //新建一个线程ServerSocket，并开启
                if(!SERVER_SOCKET.isClosed())
                	new SMTPServerSocketThread(socket).start();
                
//                cnt++;
//                if(cnt==2)break;
            }
            System.out.println("******SMTP服务器已关闭*****");
            log=new Log();
            log.setOperation("******SMTP服务器已关闭*****");
            log.setDate(new Timestamp(System.currentTimeMillis()));
            log.setState("1");
            logDao = new LogDaoImpl();
            logDao.insert(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void SMTPClose() throws InterruptedException {
    	try {
    		new Socket("127.0.0.1",PORT.SMTPPORT);
    		Thread.sleep(5);
			SERVER_SOCKET.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }

    public static void main(String[] args) throws Exception {
    	SMTPOpen();
    }
}