package com.core.util;

import org.apache.log4j.Logger;

public class LogHelper {
	private static Logger logger = Logger.getLogger(LogHelper.class);

	// singleton bean created by Spring
	private static LogHelper logHelper = null;

	// injected by Spring
	private IOnlineLog onlineLog = null;
	private IBatchLog batchLog = null;

	public LogHelper() {
		logger.debug("LogHelper instance create!!");
		logHelper = this;
	}

	public void setOnlineLog(IOnlineLog onlineLog) {
		this.onlineLog = onlineLog;
	}

	public void setBatchLog(IBatchLog batchLog) {
		this.batchLog = batchLog;
	}

	public static String test(Object msg) {
		if (logHelper != null && logHelper.onlineLog != null
				&& logHelper.batchLog != null) {
			return "\n=== LogHelper Test ===\n" + msg.toString();
		} else {
			return msg.toString();
		}
	}

	// OnlineLog Helper
	public static String InfoLog(Object msg) {
		if (logHelper != null && logHelper.onlineLog != null)
			return logHelper.onlineLog.InfoLog(msg);
		else
			return msg.toString();
	}

	public static String FuncLog(Object msg) {
		if (logHelper != null && logHelper.onlineLog != null)
			return logHelper.onlineLog.FuncLog(msg);
		else
			return msg.toString();
	}

	public static String ErrLog(Object msg) {
		if (logHelper != null && logHelper.onlineLog != null)
			return logHelper.onlineLog.ErrLog(msg);
		else
			return msg.toString();
	}

	public static String Fatal(Object msg) {
		if (logHelper != null && logHelper.onlineLog != null)
			return logHelper.onlineLog.Fatal(msg);
		else
			return msg.toString();
	}

	// BatchLog Helper
	public static String WriteLogBegin(Object msg) {
		if (logHelper != null && logHelper.batchLog != null)
			return logHelper.batchLog.WriteLogBegin(msg);
		else
			return msg.toString();
	}

	public static String WriteLogEnd(Object msg) {
		if (logHelper != null && logHelper.batchLog != null)
			return logHelper.batchLog.WriteLogEnd(msg);
		else
			return msg.toString();
	}

	public static String FunctionLogBegin(Object msg) {
		if (logHelper != null && logHelper.batchLog != null)
			return logHelper.batchLog.FunctionLogBegin(msg);
		else
			return msg.toString();
	}

	public static String FunctionLogEnd(Object msg) {
		if (logHelper != null && logHelper.batchLog != null)
			return logHelper.batchLog.FunctionLogEnd(msg);
		else
			return msg.toString();
	}

	public static String StepInfo(Object msg) {
		if (logHelper != null && logHelper.batchLog != null)
			return logHelper.batchLog.StepInfo(msg);
		else
			return msg.toString();
	}

	public static String StepLog(Object msg) {
		if (logHelper != null && logHelper.batchLog != null)
			return logHelper.batchLog.StepLog(msg);
		else
			return msg.toString();
	}

	public static String StepError(Object msg) {
		if (logHelper != null && logHelper.batchLog != null)
			return logHelper.batchLog.StepError(msg);
		else
			return msg.toString();
	}

	public static String StepFatal(Object msg) {
		if (logHelper != null && logHelper.batchLog != null)
			return logHelper.batchLog.StepFatal(msg);
		else
			return msg.toString();
	}

}
