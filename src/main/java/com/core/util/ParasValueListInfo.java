package com.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;


public class ParasValueListInfo {
	private Hashtable<String, ArrayList<Object>> parametersValuesList;
	
	public ParasValueListInfo() {
		parametersValuesList = new Hashtable<String, ArrayList<Object>>();
    }
	
	public void AddParameterValue(String strParaName, Object objParaValue) {
		ArrayList<Object> list = new ArrayList<Object>();
        // 如果存在，繼續加入
        if (parametersValuesList.containsKey(strParaName)) {
        	list = parametersValuesList.get(strParaName);
        	list.add(objParaValue);
        } else {
            list.add(objParaValue);
            parametersValuesList.put(strParaName, list);
        }
    }
	
	public int GetListCount() {
		Enumeration<String> keyColl = parametersValuesList.keys();
        int intCount = 0;
        for (Object strKey : Collections.list(keyColl)) {
            if (intCount == 0) {
                intCount = parametersValuesList.get(strKey).size();
            } else {
                if (intCount != parametersValuesList.get(strKey).size()) {
                    return -3;
                }
            }
        }
        return intCount;
    }
	
	/// <summary>
    /// 2009.09.03
    /// 帶入key strParaName 及arraylist的rowIndex
    /// 取出對應的value
    /// </summary>
    /// <param name="strParaName"></param>
    /// <param name="rowIndex"></param>
    /// <returns></returns>
    public Object GetParameterValue(String strParaName, int rowIndex) {
        if (parametersValuesList.containsKey(strParaName)) {
            // 如果 ArrayList的數量-1 大於等於 rowIndex，表示 rowIndex 合理
            if (parametersValuesList.get(strParaName).size() - 1 >= rowIndex) {
                return parametersValuesList.get(strParaName).get(rowIndex);
            } else {
                return null;
            }
        } else {
            return null;
        }
    } 
}
