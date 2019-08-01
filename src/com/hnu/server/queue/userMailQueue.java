package com.hnu.server.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class userMailQueue {
	public static Lock lock =  new ReentrantLock();
	public volatile static HashMap<Integer,Queue<Integer>> user = new HashMap<Integer,Queue<Integer>>();
	
	public static void insert(Integer id) {
		lock.lock();
		try {
			if(!userMailQueue.user.containsKey(id))
				userMailQueue.user.put(id, new LinkedList<Integer>());
		}finally {
			lock.unlock();
		}
	}
	
	public static void receiveMail(Integer userid,Integer mailid){
		lock.lock();
		try {
			user.get(userid).add(mailid);
		}finally {
			lock.unlock();
		}
    }
	
    public static int sendMail(Integer userid){
    	int mailid=0;
    	lock.lock();
		try {
	    	if(user.containsKey(userid)&&!user.get(userid).isEmpty())
	    	{
	    		mailid = user.get(userid).poll();
	    	}
		}finally {
			lock.unlock();
		}
		return mailid;
    }
}
