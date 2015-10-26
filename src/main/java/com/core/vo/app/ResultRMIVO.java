package com.core.vo.app;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class ResultRMIVO implements Serializable {
	
	private Object result;
	private int status = 0;
	private String msgDesc = StringUtils.EMPTY;
	private String message = StringUtils.EMPTY;
	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the msgDesc
	 */
	public String getMsgDesc() {
		return msgDesc;
	}
	/**
	 * @param msgDesc the msgDesc to set
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
