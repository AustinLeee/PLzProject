package com.core.vo.app;


public class SearchResultRMIVO extends ResultRMIVO{	
	private Long rowCounts = 0L;

	/**
	 * @return the rowCounts
	 */
	public Long getRowCounts() {
		return rowCounts;
	}

	/**
	 * @param rowCounts the rowCounts to set
	 */
	public void setRowCounts(Long rowCounts) {
		this.rowCounts = rowCounts;
	}
}
