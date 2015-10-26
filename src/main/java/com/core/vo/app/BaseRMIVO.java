package com.core.vo.app;

public class BaseRMIVO implements java.io.Serializable{
	
	private String rowStatus = "R";
	
	private String isSelected = "N";
	
	/**
	 * D : 表示刪除資料
	 */
	public static final String ROW_STATUS_DELETE = "D";
	/**
	 * U : 表示修改資料
	 */
	public static final String ROW_STATUS_UPDATE = "U";
	/**
	 * C : 表示新增資料
	 */
	public static final String ROW_STATUS_INSERT = "C";
	/**
	 * R : 表示讀取資料
	 */
	public static final String ROW_STATUS_READ = "R";
	/**
	 * @return the rowStatus
	 */
	public String getRowStatus() {
		return rowStatus;
	}

	/**
	 * @param rowStatus the rowStatus to set
	 */
	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}

	/**
	 * @return the isSelected
	 */
	public String getIsSelected() {
		return isSelected;
	}

	/**
	 * @param isSelected the isSelected to set
	 */
	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

	/**
	 * 是否為新增狀態
	 * @return true:新增狀態, fasle:不為新增狀態
	 */
	public boolean isInsertRowStatus() {
		return ROW_STATUS_INSERT.equals(this.rowStatus);
	}
	
	/**
	 * 是否為修改狀態
	 * @return true:修改狀態, false:不為修改狀態
	 */
	public boolean isUpdateRowStatus() {
		return ROW_STATUS_UPDATE.equals(this.rowStatus);
	}
	
	/**
	 * 是否為刪除狀態
	 * @return true:刪除狀態, false:不為刪除狀態
	 */
	public boolean isDeleteRowStatus() {
		return ROW_STATUS_DELETE.equals(this.rowStatus);
	}
}
