package com.hnu.server.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

public class ClientTestSMTP {

    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket socket = null;
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader in = null;
        
        try {
        	
            socket = new Socket("127.0.0.1", 25);
            // 获取输出流向服务端写入数据
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            String from = "fyp@mail.com";
            String to = "yc@mail.com";
            String subject = "hello";
//            String date = (new Timestamp(new java.util.Date().getTime())).toString();
            String date="2019-05-18 00:59:02";
            String content = "你好\n我是xxx！";
            
            String message = null;
            message=from+"\r\n"+to+"\r\n"+subject+"\r\n"+date+"\r\n"+content+"\r\n";
            System.out.println(message);
            pw.write(message);
            pw.flush();
            socket.shutdownOutput();
            
            // 获取输入流接受服务端返回的信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr);
            
            System.out.println(in.readLine());
            socket.shutdownInput();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
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
            if (pw != null) {
                pw.close();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}