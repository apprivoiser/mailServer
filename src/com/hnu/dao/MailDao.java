package com.hnu.dao;

import java.util.List;

import com.hnu.pojo.Mail;

public interface MailDao {
	public int insert(Mail mail) throws Exception;
    public void delete(int id) throws Exception;
    public Mail queryById(int id) throws Exception;
    public List<Mail> mailShowByUnameDao(String uname);
}
