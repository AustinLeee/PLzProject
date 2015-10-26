package com.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class BatchLogImpl implements IBatchLog {

	// general log info.
	private static String hostname;
	private static String ip;
	private static String header;

	public BatchLogImpl() {
		try {
			hostname = InetAddress.getLocalHost().getHostName().toString();
			ip = InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e) {
			hostname = "unknown";
			ip = "unknown";
		}
		header = "\n=== BATCH LOG ===" 
			   + "\nhostname:" + hostname 
			   + "\nip:" + ip 
			   + "\n";
	}
	
	@Override
	public String WriteLogBegin(Object msg) {
		return (header + "### WriteLogBegin ###\n" + msg);
	}

	@Override
	public String WriteLogEnd(Object msg) {
		return (header + "### WriteLogEnd ###\n" + msg);
	}

	@Override
	public String FunctionLogBegin(Object msg) {
		return (header + "### FunctionLogBegin ###\n" + msg);
	}

	@Override
	public String FunctionLogEnd(Object msg) {
		return (header + "### FunctionLogEnd ###\n" + msg);
	}

	@Override
	public String StepInfo(Object msg) {
		return (header + "### StepInfo ###\n" + msg);
	}

	@Override
	public String StepLog(Object msg) {
		return (header + "### StepLog ###\n" + msg);
	}

	@Override
	public String StepError(Object msg) {
		return (header + "### StepError ###\n" + msg);
	}

	@Override
	public String StepFatal(Object msg) {
		return (header + "### StepFatal ###\n" + msg);
	}

}
