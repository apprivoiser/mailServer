package com.hnu.server.test;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hnu.server.pop3.POP3;
import com.hnu.server.queue.userMailQueue;
import com.hnu.server.smtp.SMTP;
import com.hnu.utils.DBConnection;

public class Test {
	public static void main(String[] args) throws Exception {
		
		SMTP.SMTPOpen();
//		SMTP.SMTPClose();
//		POP3.POP3Open();
//		POP3.POP3Close();
//		System.out.print(userMailQueue.user);
		
//		 Date date = new Date();
//	 		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	 		String time = df.format(date);
//	 		System.out.println("*********"+time);
////	 		Timestamp now = time.;
//	 		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	 		Timestamp ts = new Timestamp(format.parse(time).getTime());
		
	}	
}
