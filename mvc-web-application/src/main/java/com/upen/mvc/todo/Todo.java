package com.upen.mvc.todo;
 
import java.util.Date;

import javax.validation.constraints.Size;

import org.apache.log4j.Logger;

import com.upen.mvc.login.LoginController;

public class Todo {

	protected static Logger log = Logger.getLogger(Todo.class);

	private int id;
	private String user;
	
	@Size (min=6, message = "Atlest 6 characters are required.")
	private String desc;
	
	private Date targetDate;
	private boolean isDone;

	public Todo() {
		super();
	}
	
	public Todo(int id, String user, String desc, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
		
	}

	@Override
	public String toString() {
		return " ToString - Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", targetDate=" + targetDate
				+ ", isDone=" + isDone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
