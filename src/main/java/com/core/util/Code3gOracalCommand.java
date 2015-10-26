package com.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.driver.OracleConnection;

public class Code3gOracalCommand extends Code3gDbCommand {

	private OraclePreparedStatement statement;
	public Code3gOracalCommand(String commandText, DbParameter[] dbParameters, ParasValueListInfo parasValueListInfo) throws Exception {
		super(commandText, dbParameters, parasValueListInfo);
		statement = (OraclePreparedStatement) getPreparedStatement();
	}

	private static final int handleCount = 5000;
	private static final String driverClass = "oracle.jdbc.driver.OracleDriver";
	
	@Override
	public int Execute() throws Exception {
		int intCount = getParasValueListInfo().GetListCount();
        if (intCount <= 0) {
            return 0;
        }
        try{
        	statement.getConnection().setAutoCommit(false);
        	statement.setExecuteBatch(handleCount);
	        for(int index=0; index < intCount; index++) {
	        	SetPatameters(index);
	        	statement.executeUpdate();
	        }
	        statement.sendBatch();
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
        		statement.setObjectAtName(strKey, value);
        	else
        		statement.setObjectAtName(strKey, value, type);
        }
    }  
	
	private OracleConnection connection;
	@Override
	protected Connection getConnection() throws Exception {
		if(connection == null || connection.isClosed()) {
			Class.forName(driverClass).newInstance();
			connection = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@172.22.4.103:1521:BMSPH3SIT2","SIT2MTPH3","SIT2MTPH3");
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
