package com.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class OnlineLogImpl implements IOnlineLog {

	// general log info.
	private static String hostname;
	private static String ip;
	private static String header;

	public OnlineLogImpl() {
		try {
			hostname = InetAddress.getLocalHost().getHostName().toString();
			ip = InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e) {
			hostname = "unknown";
			ip = "unknown";
		}
		header = "\n=== ONLINE LOG ===" 
			   + "\nhostname:" + hostname 
			   + "\nip:" + ip 
			   + "\n";
	}

	@Override
	public String InfoLog(Object msg) {
		return (header + "### InfoLog ###\n" + msg);
	}

	@Override
	public String FuncLog(Object msg) {
		return (header + "### FuncLog ###\n" + msg);
	}

	@Override
	public String ErrLog(Object msg) {
		return (header + "### ErrLog ###\n" + msg);
	}

	@Override
	public String Fatal(Object msg) {
		return (header + "### Fatal ###\n" + msg);
	}

}
