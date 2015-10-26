package com.core.util;

public class ValidationUtil {

	/**
	 * 驗證品號是否正確
	 * @param itemCode
	 * @return 正確:true 不正確:false
	 */
	public final static boolean checkItemCode(String itemCode){
//		"品號公式：
//		1、品號5碼 + 檢查碼1碼：ABCDEF
//		2、品號檢查碼F = (A * 7 + B * 3 + C * 1 + D * 7 + E * 3 )/10 之餘數
//		3、如果 F = 0，則檢查碼 = 0
		boolean boo = false;
	    if(!RegExpression.parseString(RegExpression.regNumber, itemCode))
	    	return false;
		if(itemCode.length() == 6){
			int checkNo = (Integer.parseInt(itemCode.substring(0,1))*7 + 
			Integer.parseInt(itemCode.substring(1,2))*3 +
			Integer.parseInt(itemCode.substring(2,3))*1 +
			Integer.parseInt(itemCode.substring(3,4))*7 +
			Integer.parseInt(itemCode.substring(4,5))*3)%10 ;
			if(Integer.parseInt(itemCode.substring(5,6)) == checkNo)
				boo = true;			
		}
		return boo;
	}


	/**
	 * 驗證店號是否正確	
	 * @param itemCode
	 * @return 正確:true 不正確:false
	 */
	public final static boolean checkStoreCode(String storeCode){
//		店號公式：
//		1、店號5碼 + 檢查碼1碼： ABCDEF
//		2、店號檢查碼F = (A * 5 + B * 7 + C * 3 + D * 3 + E * 1 )/10 之餘數
//		3、如果 F = 0，則檢查碼 = 0
		boolean boo = false;
	    if(!RegExpression.parseString(RegExpression.regNumber, storeCode))
	    	return false;
		if(storeCode.length() == 6){
			int checkNo = (Integer.parseInt(storeCode.substring(0,1))*5 + 
			Integer.parseInt(storeCode.substring(1,2))*7 +
			Integer.parseInt(storeCode.substring(2,3))*3 +
			Integer.parseInt(storeCode.substring(3,4))*3 +
			Integer.parseInt(storeCode.substring(4,5))*1)%10 ;
			if(Integer.parseInt(storeCode.substring(5,6)) == checkNo)
				boo = true;			
		}
		return boo;
	}
	
	/**
	 * 公司統編驗證	
	 * @param storeCode
	 * @return 正確:true 不正確:false
	 */
	public final static boolean checkCompNumber(String compNumber){
//		check_comp_number		公司統編驗證	"廠商統編
//		1、統一編號8碼 + 流水號2碼：ABCDEFGHIJ
//		2、A - H 個別乘上特定倍數，若乘出來的值為二位數則將十位數和個位數相加
//		3、Z = (A * 1 + B * 2 + C * 1 + D * 2 + E * 1 + F * 2 + G * 4 + H * 1 )/10 之餘數
//		4、如果 Z = 0，此統編正確。
//		5、如果Z != 0，但G = 7且 (Z+1)/10之餘數= 0，此統編正確。
	    if (compNumber == null || compNumber.trim().length() != 8)
	        return false;
	    if(!RegExpression.parseString(RegExpression.regNumber, compNumber))
	    	return false;
	    int[] Logic = new int[] { 1, 2, 1, 2, 1, 2, 4, 1 };
	    int addition, sum = 0, j = 0, x;
	    for (x = 0; x < Logic.length; x++) {
	        int no = Integer.parseInt(compNumber.substring(x, x+1));
	        j = no * Logic[x];
	        addition = ((j / 10) + (j % 10));
	        sum += addition;
	    }
	    if (sum % 10 == 0) {
	        return true;
	    }
	    if (compNumber.substring(6, 7) == "7") {
	        if (sum % 10 == 9){
	            return true;
	        }
	    }
	    return false;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		System.out.println(checkItemCode("000068"));
		System.out.println(checkStoreCode("972549"));
		System.out.println(checkCompNumber("16151427"));
		
	}
	

}
