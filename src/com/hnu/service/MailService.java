package com.hnu.service;

import com.hnu.pojo.Mail;

public interface MailService {
	int insertService(Mail mail);
	void deleteService(int id) ;
    Mail queryByIdService(int id);

}
