package com.awzpact.rest.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timeStamp;
	private String message;
	private String details;
	private int status;
	
	
	public ErrorDetails(Date timeStamp, String message, String details, int status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
		this.status = status;
	}
	
	
	
	
	public int getStatus() {
		return status;
	}




	public void setStatus(int status) {
		this.status = status;
	}




	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
