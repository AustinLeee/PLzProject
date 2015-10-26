package com.core.util;

public interface IOnlineLog {
	public String InfoLog(Object msg);
	public String FuncLog(Object msg);
	public String ErrLog(Object msg);
	public String Fatal(Object msg);
}
