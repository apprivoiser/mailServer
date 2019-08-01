package com.hnu.server.port;

import com.hnu.server.switches.MyThread;

public class PORT {
	public static int SMTPPORT=25;
	public static int POP3PORT=110;
	public static int mailboxSize=5000;
	
	public static void changeSMTPPORT(int port) throws InterruptedException {
		MyThread.serviceSwitch(2);
		Thread.sleep(20);
		SMTPPORT=port;
		MyThread.serviceSwitch(1);
		Thread.sleep(5);
	}
	
	public static void changePOP3PORT(int port) throws InterruptedException {
		MyThread.serviceSwitch(4);
		Thread.sleep(20);
		POP3PORT=port;
		MyThread.serviceSwitch(3);
		Thread.sleep(5);
	}
	public static void changeMailboxSize(int size){
		mailboxSize=size;
	}
}
