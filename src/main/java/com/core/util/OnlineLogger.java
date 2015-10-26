package com.core.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class OnlineLogger {
	private Logger log4j;

	public static OnlineLogger getLogger(String name) {
		return new OnlineLogger(name);
	}

	public static OnlineLogger getLogger(Class clazz) {
		return new OnlineLogger(clazz);
	}

	private OnlineLogger() {
	}

	private OnlineLogger(String name) {
		log4j = Logger.getLogger(name);
	}

	private OnlineLogger(Class clazz) {
		log4j = Logger.getLogger(clazz);
	}

	public void InfoLog(Object msg) {
		String message = "Online Info - " + msg.toString();
		log4j.log(log4j.getName(), Level.INFO, message, null);
	}
	
	public void FuncLog(Object msg) {
		String message = "Online Func - " + msg.toString();
		log4j.log(log4j.getName(), Level.DEBUG, message, null);
	}
	
	public void ErrLog(Object msg) {
		String message = "Online Error - " + msg.toString();
		log4j.log(log4j.getName(), Level.ERROR, message, null);
	}
	
	public void Fatal(Object msg) {
		String message = "Online Fatal - " + msg.toString();
		log4j.log(log4j.getName(), Level.FATAL, message, null);
	}

}
