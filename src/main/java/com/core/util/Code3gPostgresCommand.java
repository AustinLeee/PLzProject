package com.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Code3gPostgresCommand extends Code3gDbCommand {

	private PreparedStatement statement;
	public Code3gPostgresCommand(String commandText, DbParameter[] dbParameters, ParasValueListInfo parasValueListInfo) throws Exception {
		super(commandText, dbParameters, parasValueListInfo);
		statement = getPreparedStatement();
	}

	private static final String driverClass = "org.postgresql.Driver";
	
	@Override
	public int Execute() throws Exception {
		int intCount = getParasValueListInfo().GetListCount();
        if (intCount <= 0) {
            return 0;
        }
        try{
        	statement.getConnection().setAutoCommit(false);
        	//StringBuilder sb = new StringBuilder();
        	//sb.append("insert into BD_DF (YM,STORE,AW_ID,BMS,ACCT,REASON,BMS_ACCT,WAY) values");
        	//boolean other = false;
	        for(int index=0; index < intCount; index++) {
	        	SetPatameters(index);
	        	statement.addBatch();
	        	//if(o) sb.append(",");
	        	//sb.append(" ('a','a','a',1,1,'a',1,'a') ");
	        	//other = true;
	        	if(index > 0 && index % 5000 == 0) {
	        		//statement = statement.getConnection().prepareStatement(sb.toString());
	        		//statement.execute();
	        		//sb = new StringBuilder();
	            	//sb.append("insert into BD_DF (YM,STORE,AW_ID,BMS,ACCT,REASON,BMS_ACCT,WAY) values ");
	            	//o = false;
	        		statement.executeBatch();
	        		statement.clearBatch();
	        		//other = false;
	        	}
	        }
	        statement.executeBatch();
	        //if(other) { 
	        //	statement.execute();
	        //	statement = statement.getConnection().prepareStatement(sb.toString());
	        //}
	        statement.getConnection().commit();
        } catch(Exception e) {
        	statement.getConnection().rollback();
        	throw e;
        }
		return intCount;
	}

	private void SetPatameters(int index) throws Exception {
        String strKey;
        Object value;
        int type;
        for (int i = 0; i < getDbParameters().length; i++) {
        	strKey = getDbParameters()[i].getName();
        	value = getParasValueListInfo().GetParameterValue(strKey,index);
        	type = getDbParameters()[i].getType();
        	if(type < 0) 
        		statement.setObject(i + 1, value);
        	else
        		statement.setObject(i + 1, value, type);
        }
    }  
	
	private Connection connection;
	@Override
	protected Connection getConnection() throws Exception {
		if(connection == null || connection.isClosed()) {
			Class.forName(driverClass).newInstance();
			connection = DriverManager.getConnection("jdbc:postgresql://172.22.7.69/sso","postgres","postgres");
		}
		return connection;
	}
	
	@Override
	public void Close() throws SQLException {
		if(statement != null && !statement.isClosed()) {
    		statement.clearParameters();
    		statement.close();
    		if(!statement.getConnection().isClosed()) {
    			statement.getConnection().close();
    		}
    		statement = null;
    	}
	}
}
