package com.hnu.server.switches;


import com.hnu.server.pop3.POP3;
import com.hnu.server.smtp.SMTP;

public class MyThread extends Thread{
	private static int command;
	
	public void run() 
	{
		if(command==1) {
			try {
				SMTP.SMTPOpen();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command==2) {
			try {
				SMTP.SMTPClose();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command==3) {
			try {
				POP3.POP3Open();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command==4) {
			try {
				POP3.POP3Close();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void serviceSwitch(int com)
	{
		command=com;
		MyThread myThread=new MyThread();
		myThread.start();
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		serviceSwitch(1);
		Thread.sleep(1000);
		serviceSwitch(3);
		Thread.sleep(1000);
//		serviceSwitch(2);
		Thread.sleep(1000);
//		serviceSwitch(4);
	}
}
