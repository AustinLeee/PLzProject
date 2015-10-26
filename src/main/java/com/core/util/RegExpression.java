package com.core.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RegExpression {
	//regNumber9_2 ==> 7個整數 ,2個小數 oracle的處理作法 在這邊是這樣用
	//regNumber7_4 ==> 長度7     十進位3  小數4 mysql的處理作法 (123.1234要能過)
	//regNumber9_5 ==> 長度9     十進位4  小數5               (1234.12345)
	public static String regTwoNumber = "^\\d{2}$";		//???兩個數字
	public static String regFourNumber = "^\\d{4}$";	//???四個數字
	public static String regFiveNumber = "^\\d{5}$";	//五個數字
	public static String regSixNumber = "^\\d{6}$";		//六個數字
	public static String regEightNumber = "^\\d{8}$";	//八個數字
	public static String regTenNumber = "^\\d{10}$";	//十個數字
	public static String regProductNo= "^\\d{12}$";		//十二個數字
	public static String regTwelveNumber= "^\\d{12}$";		//十二個數字
	public static String regFourteenNumber= "^\\d{14}$";		//十四個數字
	public static String regNoBound3Number = "^\\d{1,3}$";//非限定三個數字
	public static String regNoBound4Number = "^\\d{1,4}$";//非限定四個數字
	public static String regNoBound5Number = "^\\d{1,5}$";//非限定五個數字
	public static String regNoBound6Number = "^\\d{1,6}$";//非限定六個數字
	public static String regNoBound7Number = "^\\d{1,7}$"; //非限定七個數字
	public static String regNoBound8Number = "^\\d{1,8}$"; //非限定八個數字
	public static String regNoBound9Number = "^\\d{1,9}$";//非限定九個數字
	public static String regNoBound10Number = "^\\d{1,10}$";//非限定十個數字
	public static String regNoBound11Number = "^\\d{1,11}$";//非限定十一個數字
	public static String regNoBound12Number = "^\\d{1,12}$";//非限定十二個數字
	public static String regNoBound13Number = "^\\d{1,13}$";//非限定十三個數字
	public static String regNoBound18Number = "^\\d{1,18}$";//非限定十八個數字
	public static String regNoBound20Number = "^\\d{1,20}$";//非限定二十個數字	
	
	public static String regNumber9_4_NoDot = "^\\d{1,5}$|(^[0-9]{1,5}\\.\\d{1,4})$";//number(9,4)  前5 後4
	public static String regNumber7_3_NoDot = "^\\d{1,4}$|(^[0-9]{1,4}\\.\\d{1,3})$";//number(7,3)  前4 後3
	public static String regNumber10_3_NoDot = "^\\d{1,7}$|(^[0-9]{1,7}\\.\\d{1,3})$";//number(10,3)  前7 後3
	public static String regNumber13_2 		 = "^\\d{1,11}$|(^[0-9]{1,11}\\.\\d{1,2})$";//number(13,2)  前11 後2

	public static String regTelephoneNumber = "([0-9]|-)+";//只允許數字和符號(-)輸入
	public static String regNumber = "^[0-9]*$";//all are number
	public static String regNumber2 = "^([1-9])?\\d$";//number(2)
	public static String regNumber4_2 = "^([1-9]?\\d)(\\.\\d{1,2})?$";//number(5,3)
	public static String regNumber5_2 = "^(([1-9]\\d{1,2})|([0-9]))(\\.\\d{1,2})?$";//number(5,2) 前3 後2
	public static String regNumber5_3 = "^([1-9]?\\d)(\\.\\d{1,3})?$";//number(5,3)
	
	public static String regNumber5 = "^((([1-9])(\\d)?(,\\d{3}))|([1-9]\\d{1,4})|(\\d))$";//number(5)
	public static String regNumber6 = "^((([1-9])(\\d{0,2})(,\\d{3}))|([1-9]\\d{1,5})|(\\d))$";//number(6)
	public static String regNumber7 = "^(([1-9](,\\d{3}){2})|(([1-9])(\\d{0,2})(,\\d{3}))|([1-9]\\d{1,6})|(\\d))$";//number(7)
	public static String regNumber7_2 = "^((([1-9])(\\d)?(,\\d{3}))|([1-9]\\d{1,4})|(\\d))(\\.\\d{1,2})?$";//number(7,2)
	public static String regNumber8_3 = "^([1-9]?\\d{0,4})(\\.\\d{1,3})?$";//number(8,3)
	public static String regNumber9 = "^((([1-9])(\\d{0,2})(,\\d{3}){1,2})|([1-9]\\d{1,8})|(\\d))$";//number(9)
	public static String regNumber9_2 = "^(([1-9](,\\d{3}){2})|(([1-9])(\\d{0,2})(,\\d{3}))|([1-9]\\d{1,6})|(\\d))(\\.\\d{1,2})?$";//number(9,2)
	public static String regNumber9_3 = "^([1-9]?\\d{0,5})(\\.\\d{1,3})?$";//number(9,3)
	public static String regNumber10_3 = "^(([1-9](,\\d{3}){2})|(([1-9])(\\d{0,2})(,\\d{3}))|([1-9]\\d{1,6})|(\\d))(\\.\\d{1,3})?$";//number(10,3)
	public static String regNumber11_3 = "^((([1-9])(\\d)?(,\\d{3}){2})|(([1-9])(\\d{0,2})(,\\d{3}))|([1-9]\\d{1,7})|(\\d))(\\.\\d{1,3})?$";//number(9,2)
	public static String regNumber12_3 = "^([1-9]?\\d{0,8})(\\.\\d{1,3})?$";//number(12,3)
	
	public static String regNumber10_3WithNegative = "^((-?[1-9](,\\d{3}){2})|((-?[1-9])(\\d{0,2})(,\\d{3}))|(-?[1-9]\\d{1,6})|(-?\\d))(\\.\\d{1,3})?$";//number(10,3)

	public static String regBarcode13 = "^\\d{13}$";//Barcode13
	public static String regBarcode12 = "^\\d{12}$";//Barcode13
	public static String regBarcode8 = "^\\d{8}$";//Barcode8

	public static String regFlag0to5 = "^([0-5])"; //dataflag 0~5	
	public static String regDateFormat = "^(\\d{4}/)([0-1]\\d/)([0-3]\\d)$";// yyyy/mm/dd
	public static String regYearMonthFormat = "^(\\d{4}/)([0-1]\\d)$";		//yyyy/mm
	public static String regFloat2 = "^\\d+(\\.\\d+)?$";//Float
	public static String regEMail = "^.+@[^\\.].*\\.[a-z]{2,}$";//Email
	public static String regNumberWithLetter = "^[A-Za-z0-9]+$";
	public static String regIsNumber = "^[-]?\\d+[.]?\\d*$";
	public static String regFlag0to1 = "^([0-1])"; //dataflag 0~1
	public static String regFlag0to9 = "^([0-9])"; //dataflag 0~9
	
	public static List<String> testNumberCase =  new ArrayList<String>();

	/**
	 * 檢驗 傳入的parseString 是否符合 傳入的 regx 格式相符
	 * @param regx
	 * @param parseString
	 * @return
	 */
	public static boolean parseString(String regx,String parseString){
		return Pattern.compile(regx).matcher(StringUtils.trim(parseString)).matches();
	}
	
	public static void main(String[] args) throws ParseException{
		System.out.println(parseString(RegExpression.regIsNumber,"12345"));
	}
}
