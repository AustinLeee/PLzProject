package com.core.util;

public interface ICode3gDbCommand {
	
    public DbParameter[] getDbParameters();
	public void setDbParameters(DbParameter[] dbParameters);
	
	public ParasValueListInfo getParasValueListInfo();
	public void setParasValueListInfo(ParasValueListInfo parasValueList);
	
    public int Execute() throws Exception;
    
    public void Close() throws Exception;
}
