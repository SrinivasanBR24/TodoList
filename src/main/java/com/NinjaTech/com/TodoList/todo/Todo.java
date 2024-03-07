package com.NinjaTech.com.TodoList.todo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Todo {

	public Todo() {
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	
	@Size(min=10,message="Enter Atlease 10 character")
	private String description;
	private LocalDate targetDate;
	private boolean isDone;
	
	
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	  
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}


	public boolean getIsDone() {
	    return isDone;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setusername(String username)
	{
		this.username=username;
	}
	
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	public void setTargetDate (LocalDate targetDate)
	{
		this.targetDate=targetDate;
	}
	public void setIsDone(boolean isDone)
	{
		this.isDone=isDone;
	}


	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", isDone=" + isDone + "]";
	}
	
	
}
