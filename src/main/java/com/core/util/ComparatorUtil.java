package com.core.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Comparator;

public class ComparatorUtil<T> implements Comparator<T>{

	public static ComparatorUtil<String> getStringComparatorUtil() {
		return new ComparatorUtil<String>();
	}
	
	public static ComparatorUtil<BigDecimal> getBigDecimalComparatorUtil() {
		return new ComparatorUtil<BigDecimal>();
	}

	/**
	 * o1與 o2 比較
	 * 回傳 0 代表相同
	 * 回傳 != 0 代表不同
	 * 
	 */
	public int compare(T o1, T o2) {
		int flag = 0;
		//當 T 為  String 類別
		if(o1 instanceof String){
			String str1 = (String)o1;
			String str2 = (String)o2;
			flag = str1.compareTo(str2);
		}/*end of if*/
		if(o1 instanceof BigDecimal){
			BigDecimal big1 = (BigDecimal)o1;
			BigDecimal big2 = (BigDecimal)o2;
			flag = big1.compareTo(big2);
		}/*end of if*/
		
		return flag;
	}

	public static void main(String[] args) throws ParseException{
		//比較 BigDecimal
		int value = ComparatorUtil.getBigDecimalComparatorUtil().compare(new BigDecimal(123.0), new BigDecimal("123.0"));
		System.out.println(value);
		//比較  字串
		value = ComparatorUtil.getStringComparatorUtil().compare("123","123");
		System.out.println(value);
	}
	
}
