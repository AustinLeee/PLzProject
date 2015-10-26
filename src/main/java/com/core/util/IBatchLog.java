package com.core.util;

public interface IBatchLog {
	public String WriteLogBegin(Object msg);
	public String WriteLogEnd(Object msg);
	public String FunctionLogBegin(Object msg);
	public String FunctionLogEnd(Object msg);
	public String StepInfo(Object msg);
	public String StepLog(Object msg);
	public String StepError(Object msg);
	public String StepFatal(Object msg);
}
