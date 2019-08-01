package com.hnu.pojo;

import java.sql.Timestamp;

public class Mail {
	private int id;
	private String from_user;
	private String to_user;
	private String subject;
	private Timestamp date;
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom_user() {
		return from_user;
	}
	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}
	public String getTo_user() {
		return to_user;
	}
	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Mail [id=" + id + ", from_user=" + from_user + ", to_user=" + to_user
				+ ", subject=" + subject +  ", date=" + date +  ", content=" + content +  "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((from_user == null) ? 0 : from_user.hashCode());
		result = prime * result + id;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((to_user == null) ? 0 : to_user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mail other = (Mail) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (from_user == null) {
			if (other.from_user != null)
				return false;
		} else if (!from_user.equals(other.from_user))
			return false;
		if (id != other.id)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (to_user == null) {
			if (other.to_user != null)
				return false;
		} else if (!to_user.equals(other.to_user))
			return false;
		return true;
	}
	
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mail(int id, String from_user, String to_user, String subject, Timestamp date, String content) {
		super();
		this.id = id;
		this.from_user = from_user;
		this.to_user = to_user;
		this.subject = subject;
		this.date = date;
		this.content = content;
	}
	
}
