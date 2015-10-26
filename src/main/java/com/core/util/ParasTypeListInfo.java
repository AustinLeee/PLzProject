package com.core.util;


import java.util.Hashtable;
import oracle.jdbc.OracleTypes;

public class ParasTypeListInfo {
	private Hashtable<String, OracleTypes> _ParametersTypeList;
	
	public ParasTypeListInfo() {
        _ParametersTypeList = new Hashtable<String, OracleTypes>();
    }
	
	public void SetParameterType(String strParaName, OracleTypes objParaValue) {
        if (!_ParametersTypeList.containsKey(strParaName)) {
            _ParametersTypeList.put(strParaName, objParaValue);
        }
    }
	
	public Hashtable<String, OracleTypes> getParametersTypeList() {
		return _ParametersTypeList;
	}
	
	public void setParametersTypeList(Hashtable<String, OracleTypes> value) {
		_ParametersTypeList = value;
	}
}
