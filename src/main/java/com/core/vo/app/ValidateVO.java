package com.core.vo.app;

/**
 * 刪除檢核結果,
 * 可刪除, successFlag設為true
 * 不可刪除, successFlag設為false, returnMsg設為要B391102中要取代$A的字串
 * @author c1214281
 *
 */
public class ValidateVO {
	private boolean successFlag;
	private String[] returnMsg;
	
	public boolean isSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(final boolean successFlag) {
		this.successFlag = successFlag;
	}
	public String[] getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(final String[] returnMsg) {
		this.returnMsg = returnMsg;
	}
}
