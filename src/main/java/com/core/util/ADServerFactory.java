package com.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class ADServerFactory {
	
	private ADServerFactory() {}
	private static ADServerFactory factory = null;
	public static ADServerFactory GetInstance() {
		if(factory == null) {
			factory = new ADServerFactory();
		}
		return factory;
	}
	
	public final String LDAPUrl = "ldap://172.22.7.127";
	public final String LDAPDomain = "ssl.com";
	public final String AdministratorId = "administrator";
	public final String AdministratorPassword = "1qaz@WSX";
	
	private String GetDCString() {
		String[] dcs = LDAPDomain.split("\\.");
		String result = "";
		for(int i=0;i<dcs.length;i++){
			result+=",DC=";
			result+=dcs[i];
		}
		return result;
	}
	
	private Hashtable<String, String> GetEnvTable(boolean isSsl,boolean isAdmin){
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");        
		env.put(Context.PROVIDER_URL, LDAPUrl);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		if(isAdmin) {
			env.put(Context.SECURITY_PRINCIPAL, AdministratorId+"@"+LDAPDomain);        
			env.put(Context.SECURITY_CREDENTIALS, AdministratorPassword);
		}
		if(isSsl){
			env.put(Context.SECURITY_PROTOCOL, "ssl");
		}
		return env;
	}
	
	//登入帳號
	//以下是回傳值
	//成功登入: Pos3gADServerState.USER_ENABLED
	//密碼錯誤: Pos3gADServerState.PASSWORD_NOT_MATCH
	//無此帳戶: Pos3gADServerState.USER_NOT_FOUND
	//帳戶停用: Pos3gADServerState.USER_DISABLED
	//密碼過期: Pos3gADServerState.PASSWORD_EXPIRED
	//密碼過期: Pos3gADServerState.PASSWORD_TIMEOUT
	//帳戶過期: Pos3gADServerState.USER_EXPIRED
	//帳號鎖定: Pos3gADServerState.USER_LOCKED
	public int Login(String accountId, String password) throws Exception{
		Hashtable<String, String> env = GetEnvTable(false,false);             
		env.put(Context.SECURITY_PRINCIPAL, "CN="+accountId+",CN=Users"+GetDCString());       
		env.put(Context.SECURITY_CREDENTIALS, password);
		LdapContext ctx = null;        
		try {           
			ctx = new InitialLdapContext(env, null);
			return ADServerState.USER_ENABLED;   
		} catch (javax.naming.AuthenticationException e) {   
			String message = e.getMessage();
			if(message.indexOf("data 52e")>0) return ADServerState.PASSWORD_NOT_MATCH; //密碼錯誤
			if(message.indexOf("data 525")>0) return ADServerState.USER_NOT_FOUND; //帳戶錯誤
			if(message.indexOf("data 533")>0) return ADServerState.USER_DISABLED; //帳戶停用
			if(message.indexOf("data 773")>0) return ADServerState.PASSWORD_EXPIRED; //密碼過期
			if(message.indexOf("data 532")>0) return ADServerState.PASSWORD_TIMEOUT; //密碼過期
			if(message.indexOf("data 701")>0) return ADServerState.USER_EXPIRED; //帳戶過期
			if(message.indexOf("data 775")>0) return ADServerState.USER_LOCKED; //帳戶鎖定
			throw e;
		} catch (javax.naming.CommunicationException e) {
			throw e;         
		} catch (Exception e) {
			throw e;
		} finally {         
			if (ctx != null) {         
				try {                
					ctx.close();         
				} catch (NamingException e) { 
					throw e;
				}        
			}    
		}
	}
	
	//新增帳戶
	//以下是回傳值
	//成功新增: Pos3gADServerState.USER_ENABLED
	//密碼不符規則: Pos3gADServerState.PASSWORD_FORMAT_ERROR
	//帳戶已存在: Pos3gADServerState.USER_EXISTS
	public int AddUser(String accountId,String password) throws Exception {
		Hashtable<String, String> env = GetEnvTable(true,true);  
		LdapContext ctx = null;
		try {
			ctx = new InitialLdapContext(env, null);
		} catch (NamingException e) {
			throw e;
		}   
		Attributes attrs = new BasicAttributes(true);   
		attrs.put("objectClass", "user");   
		attrs.put("sAMAccountName", accountId);
		attrs.put("displayName", accountId); 
		attrs.put("userPrincipalName", accountId+"@"+LDAPDomain);   
		attrs.put("mail", accountId+"@"+LDAPDomain);   
		attrs.put("userAccountControl", Integer.toString(ADServerState.USER_ENABLED + ADServerState.USER_DISABLED   
				+ ADServerState.PASSWD_NOT_REQUIRED + ADServerState.PASSWORD_EXPIRED));
		try {
			ctx.createSubcontext("CN="+accountId+",CN=Users" + GetDCString() , attrs);
		} catch (NamingException e) {
			String message = e.getMessage();
			if(message.indexOf("ENTRY_EXISTS")> 0) return ADServerState.USER_EXISTS;
			throw e;
		}
		ModificationItem[] mods = new ModificationItem[3];   
		String newQuotedPassword = "\""+password+"\"";
		byte[] newUnicodePassword = null;
		try {
			newUnicodePassword = newQuotedPassword.getBytes("UTF-16LE");
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("unicodePwd", newUnicodePassword));
		mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("userAccountControl", Integer   
				.toString(ADServerState.USER_ENABLED + ADServerState.PASSWORD_EXPIRED)));
		mods[2] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("pwdLastSet", Integer.toString(0)));
		try {
			ctx.modifyAttributes("CN="+accountId+",CN=Users"+GetDCString(), mods);
		} catch (NamingException e) {
			try {
				ctx.destroySubcontext("CN=" + accountId + ",CN=Users" + GetDCString());
			} catch (NamingException e2) {
				throw e2;
			}
			String message = e.getMessage();
			if(message.indexOf("problem 5003 (WILL_NOT_PERFORM)")>0) return ADServerState.PASSWORD_FORMAT_ERROR;
			throw e;
		}   
		return ADServerState.USER_ENABLED;
	}
	
	//重設accountId的密碼為newPassword，並設定密碼過期，須在登入時修改密碼
	//以下是回傳值
	//重設成功: Pos3gADServerState.PASSWORD_CHANGED
	//密碼不符規則: Pos3gADServerState.PASSWORD_FORMAT_ERROR
	//無此帳戶: Pos3gADServerState.USER_NOT_FOUND
	public int ResetPassword(String accountId,String newPassword,boolean needChangedNextLogin) throws Exception {
		Hashtable<String, String> env = GetEnvTable(true,true);  
		LdapContext ctx = null;
		try {
			ctx = new InitialLdapContext(env, null);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		ModificationItem[] mods = new ModificationItem[2];
		String newQuotedPassword = "\""+newPassword+"\"";
		byte[] newUnicodePassword = null;
		try {
			newUnicodePassword = newQuotedPassword.getBytes("UTF-16LE");
		} catch (Exception e) {
			throw e;
		}
		if(needChangedNextLogin) {
			mods = new ModificationItem[3];
			mods[2] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
					new BasicAttribute("pwdLastSet", Integer.toString(0)));
		}
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("unicodePwd", newUnicodePassword));
		mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("userAccountControl", Integer   
				.toString(ADServerState.USER_ENABLED + ADServerState.PASSWORD_EXPIRED)));
		try {
			ctx.modifyAttributes("CN="+accountId+",CN=Users"+GetDCString(), mods);
			return ADServerState.PASSWORD_CHANGED;
		} catch (NamingException e) {
			String message = e.getMessage();
			if(message.indexOf("problem 5003 (WILL_NOT_PERFORM)")>0) return ADServerState.PASSWORD_FORMAT_ERROR;
			if(message.indexOf("problem 2001 (NO_OBJECT)")>0) return ADServerState.USER_NOT_FOUND;
			throw e;
		} 
	}
	
	//修改登入帳戶的密碼，須傳入帳戶，舊密碼和新密碼
	//以下是回傳值
	//修改成功: Pos3gADServerState.PASSWORD_CHANGED
	//舊密碼錯誤: Pos3gADServerState.PASSWORD_NOT_MATCH
	//密碼不符規則: Pos3gADServerState.PASSWORD_FORMAT_ERROR
	//無此帳戶: Pos3gADServerState.USER_NOT_FOUND
	//帳戶停用: Pos3gADServerState.USER_DISABLED
	//帳戶過期: Pos3gADServerState.USER_EXPIRED
	public int ModifyPassword(String accountId,String oldPassword,String newPassword) throws Exception {
		int loginState = Login(accountId,oldPassword);
		if(loginState!=ADServerState.USER_ENABLED && loginState!=ADServerState.PASSWORD_EXPIRED && loginState!=ADServerState.PASSWORD_TIMEOUT) {
			return loginState;
		}
		Hashtable<String, String> env = GetEnvTable(true,true);  
		LdapContext ctx = null;
		try {
			ctx = new InitialLdapContext(env, null);
		} catch (NamingException e) {
			throw e;
		}
		ModificationItem[] mods = new ModificationItem[2];
		String newQuotedPassword = "\""+newPassword+"\"";
		byte[] newUnicodePassword = null;
		try {
			newUnicodePassword = newQuotedPassword.getBytes("UTF-16LE");
		} catch (Exception e) {
			throw e;
		}
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("unicodePwd", newUnicodePassword));
		mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("userAccountControl", Integer   
						.toString(ADServerState.USER_ENABLED + ADServerState.PASSWORD_EXPIRED)));
		try {
			ctx.modifyAttributes("CN="+accountId+",CN=Users"+GetDCString(), mods);
			return ADServerState.PASSWORD_CHANGED;
		} catch (NamingException e) {
			String message = e.getMessage();
			if(message.indexOf("problem 5003 (WILL_NOT_PERFORM)")>0) return ADServerState.PASSWORD_FORMAT_ERROR;
			throw e;
		} 
	}
	
	//停用使用者
	//以下是回傳值
	//成功停用: Pos3gADServerState.USER_DISABLED
	//無此帳戶: Pos3gADServerState.USER_NOT_FOUND
	public int DisableUser(String accountId) throws Exception {
		Hashtable<String, String> env = GetEnvTable(true,true);
		ModificationItem[] mods = new ModificationItem[1];
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("userAccountControl", Integer.toString(ADServerState.USER_DISABLED)));
		LdapContext ctx = null;
		try {
			ctx = new InitialLdapContext(env, null);
			ctx.modifyAttributes("CN=" + accountId + ",CN=Users" + GetDCString(), mods);
			return ADServerState.USER_DISABLED;
		} catch (NamingException e) {
			String message = e.getMessage();
			if(message.indexOf("problem 2001 (NO_OBJECT)")>0) return ADServerState.USER_NOT_FOUND;
			throw e;
		}   
	}
	
	//啟用使用者
	//以下是回傳值
	//成功啟用: Pos3gADServerState.USER_ENABLED
	//無此帳戶: Pos3gADServerState.USER_NOT_FOUND
	public int EnableUser(String accountId) throws Exception {
		Hashtable<String, String> env = GetEnvTable(true,true);
		ModificationItem[] mods = new ModificationItem[1];
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,   
				new BasicAttribute("userAccountControl", Integer.toString(ADServerState.USER_DISABLED)));
		LdapContext ctx = null;
		try {
			ctx = new InitialLdapContext(env, null);
			ctx.modifyAttributes("CN=" + accountId + ",CN=Users" + GetDCString(), mods);
			return ADServerState.USER_ENABLED;
		} catch (NamingException e) {
			String message = e.getMessage();
			if(message.indexOf("problem 2001 (NO_OBJECT)")>0) return ADServerState.USER_NOT_FOUND;
			throw e;
		}   
	}
	
	//刪除使用者
	public void DeleteUser(String accountId) throws Exception {
		Hashtable<String, String> env = GetEnvTable(true,true);
		LdapContext ctx = null;
		try {
			ctx = new InitialLdapContext(env, null);
			ctx.destroySubcontext("CN=" + accountId + ",CN=Users" + GetDCString());
		} catch (NamingException e) {
			throw e;
		}   
	}
}
