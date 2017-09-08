package com.spring.study.exception;
import java.util.List;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {
	public final static int DISP_MODE_DEFAULT	= 100;
	public final static int DISP_MODE_ALERT		= 200;
	
	private String message = "";
	private List<String> messageList;
	private int resultCode	= 100;
	private int dispMode	= 100;
	
	public BadRequestException() {}
	
	public BadRequestException(int dispMode, String message) {
		this.dispMode	= dispMode;
		this.message	= message;
	}
	
	public BadRequestException(String message) {
		this.setMessage(message);
	}
	
	public BadRequestException(String message, int resultCode) {
		this.setMessage(message);
		this.setResultCode(resultCode);
	}
	
	public BadRequestException(List<String> messageList) {
		this.setMessageList(messageList);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public int getDispMode() {
		return dispMode;
	}

	public void setDispMode(int dispMode) {
		this.dispMode = dispMode;
	}

}
