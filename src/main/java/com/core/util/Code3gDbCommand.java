package com.core.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class Code3gDbCommand implements ICode3gDbCommand {
	
	public Code3gDbCommand(String commandText, DbParameter[] dbParameters, ParasValueListInfo parasValueListInfo) throws Exception {
		setCommandText(commandText);
		setPreparedStatement(getConnection().prepareStatement(getCommandText()));
    	setDbParameters(dbParameters);
        setParasValueListInfo(parasValueListInfo);
	}
	
	private String commandText;
	public String getCommandText() {
		return commandText;
	}
	private void setCommandText(String commandText) {
		this.commandText = commandText;
	}
	
	protected abstract Connection getConnection() throws Exception;
	
	private PreparedStatement preparedStatement;
	protected PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	private void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	private DbParameter[] dbParameters;
	@Override
	public DbParameter[] getDbParameters() {
		return dbParameters;
	}
	@Override
	public void setDbParameters(DbParameter[] dbParameters) {
		this.dbParameters = dbParameters;
	}
	
	private ParasValueListInfo parasValueListInfo;
	@Override
	public ParasValueListInfo getParasValueListInfo() {
		return parasValueListInfo;
	}
	@Override
	public void setParasValueListInfo(ParasValueListInfo parasValueListInfo) {
		this.parasValueListInfo = parasValueListInfo;
	}
	
}
