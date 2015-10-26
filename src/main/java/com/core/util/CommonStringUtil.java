package com.core.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;

public class CommonStringUtil {

	public static String NUMBER_FORMAT0 = "#";
	public static String NUMBER_FORMAT1 = "###,###";
	public static String NUMBER_FORMAT2 = "###,###.00";
	
	/**將數字字串 轉為***,***.**的格式 
	 * @param String number
	 * @return String number
	 */
	public static String numberFormat(String number, String numberFormat){
		DecimalFormat decFormat = new DecimalFormat(numberFormat);
		if( StringUtils.isBlank(number) || number.equals("null") ) {
			number = "0";
		}
		String resultStr = decFormat.format(new BigDecimal(number));
		return resultStr;
	}
	
	/**
	 * 字串補0
	 * num = 傳入的值，len = 總長度
	 * @param num
	 * @param len
	 * @return
	 */
	public static String addZero(Integer num, int len) {
		String newStr = "";
		String str = String.valueOf(num.intValue());
		int strLength = str.length();
		int addZeroLen = len - strLength;
		StringBuffer addZeroStr=new StringBuffer("");
		if( addZeroLen > 0 ){
			for (int i=0;i<addZeroLen;i++) {
				addZeroStr.append("0");
			}			
			if (addZeroStr.equals("")) {
				newStr = str;
			} else {
				newStr = addZeroStr.toString()+str;
			}
		} else {
			newStr =str;
		}
		return newStr;
	}
	
	/**
	 * num = 傳入的值，len = 總長度
	 * @param num
	 * @param len
	 * @return
	 */
	public static String addZero(int num, int len) {
		String newStr = "";
		String str = String.valueOf(num);
		int strLength = str.length();
		int addZeroLen = len - strLength;
		StringBuffer addZeroStr=new StringBuffer("");
		if( addZeroLen > 0 ){
			for (int i=0;i<addZeroLen;i++) {
				addZeroStr.append("0");
			}			
			if (addZeroStr.equals("")) {
				newStr = str;
			} else {
				newStr = addZeroStr.toString()+str;
			}
		} else {
			newStr =str;
		}
		return newStr;
	}
	
	
	/**
	 * 取得字串長度,中文兩碼,英文一碼
	 * @param str
	 * @return
	 */
	public static int getStringLength(String str) {
		return str.getBytes().length;
	}
	

	/**
	 * 檢查是否為數字
	 * @param sText
	 * @return 是數字：true，不是數字：false
	 */
	public static boolean isNumber(String sText) {
		   String ValidChars = "0123456789.";
		   boolean IsNumber=true;
		   char sChar;

		   for (int i = 0; i < sText.length() && IsNumber == true; i++) {
			   sChar = sText.charAt(i);
		      if (ValidChars.indexOf(sChar) == -1) {
		         IsNumber = false;
		      }
		   }
		   return IsNumber;
	}
	
	/**
	 * 檢查是否為整數
	 * @param sText
	 * @return 是整數：true，不是整數：false
	 */
	public static boolean isInteger(String sText) {
		   String ValidChars = "0123456789";
		   boolean IsInteger=true;
		   char sChar;

		   for (int i = 0; i < sText.length() && IsInteger == true; i++) {
			   sChar = sText.charAt(i);
		      if (ValidChars.indexOf(sChar) == -1) {
		    	  IsInteger = false;
		      }
		   }
		   return IsInteger;
	}

	/**
	 * 從map取得String的值，如果map中不存在則返回null
	 * @param map
	 * @param key
	 * @return
	 */
	public static String getStringFromMap(Map map, String key){
		final Object obj = map.get(key);
		if(null == obj){
			return null;
		}else{
			return (String)obj;
		}
	}
	
	public static void main(String[] args) throws ParseException{
		//將數字字串 轉為***,***.**的格式
		System.out.println(numberFormat("123456",NUMBER_FORMAT2));
		//字串補0
		System.out.println(addZero(new Integer("12345"),10));
		//字串補0
		System.out.println(addZero(Integer.parseInt("12345"),10));		
		//取得字串長度,中文兩碼,英文一碼
		System.out.println(getStringLength("取得字串長度,中文兩碼,英文一碼,ABC"));
		//檢查是否為數字
		System.out.println(isNumber("12345"));
		//檢查是否為整數
		System.out.println(isInteger("12345.6"));		
		
	}
	
}
