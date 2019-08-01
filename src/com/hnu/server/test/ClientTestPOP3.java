package com.hnu.server.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTestPOP3 {

    public static void main(String[] args) {

        Socket socket = null;
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader in = null;
        
        try {
        	socket = new Socket("127.0.0.1", 110);
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("yc@mail.com");
            pw.flush();
            socket.shutdownOutput();
            
            System.out.println("服务端发来消息：");
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr); 
            String message = null;
            while ((message = in.readLine()) != null) {
            	if(!message.equals("ExOxF"))
            		System.out.println(message);
            	else
            		System.out.println("");
            }
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