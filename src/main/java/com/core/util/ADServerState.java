package com.core.util;

public interface ADServerState {
	//帳戶正常
	public static final int USER_ENABLED = 0x0200;
	//帳戶已停用
	public static final int USER_DISABLED = 0x0002;
	//不需要求密碼
	public static final int PASSWD_NOT_REQUIRED = 0x0020;
	//密碼不可更改
	public static final int PASSWORD_CANT_CHANGE = 0x0040;
	//密碼永不過期
	public static final int PASSWORD_NEVER_EXPIRED = 0x10000;
	//密碼以過期
	public static final int PASSWORD_EXPIRED = 0x800000;
	//密碼以過期 8388609 
	public static final int PASSWORD_TIMEOUT = 0x800001;
	//找不到帳戶 9437184
	public static final int USER_NOT_FOUND = 0x900000;
	//密碼不符合 9437185
	public static final int PASSWORD_NOT_MATCH = 0x900001;
	//帳戶過期
	public static final int USER_EXPIRED = 0x900002;
	//帳戶已存在
	public static final int USER_EXISTS = 0x900003;
	//密碼不符合規則  9437188 
	public static final int PASSWORD_FORMAT_ERROR = 0x900004;
	//帳號已被鎖定
	public static final int USER_LOCKED = 0x900005;
	//密碼已變更
	public static final int PASSWORD_CHANGED = 0x910000;
}
