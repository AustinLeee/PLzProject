package com.core.vo.app;

public class QueryRMIVO extends TransSettingRMIVO{	
	private String hql = "";	
	private int maxRows = 10;
	private int offset = 0;
	private Long count = 0l;	
	private String returnDataType = "Object";//support "Object" or "XML" data type
	private String fieldNames[] = null;//for "XML" data type use
	private String transModelToXMLMethodName = "";//
	
	private CompositeIdVO compositeIdVO = null;
	/**
	 * @return the hql
	 */
	public String getHql() {
		return hql;
	}
	/**
	 * @param hql the hql to set
	 */
	public void setHql(String hql) {
		this.hql = hql;
	}
	/**
	 * @return the maxRows
	 */
	public int getMaxRows() {
		return maxRows;
	}
	/**
	 * @param maxRows the maxRows to set
	 */
	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}
	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}
	/**
	 * @param offset the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}	
	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}
	/**
	 * @return the returnDataType
	 */
	public String getReturnDataType() {
		return returnDataType;
	}
	/**
	 * @param returnDataType the returnDataType to set
	 */
	public void setReturnDataType(String returnDataType) {
		this.returnDataType = returnDataType;
	}
	/**
	 * @return the fieldNames
	 */
	public String[] getFieldNames() {
		return fieldNames;
	}
	/**
	 * @param fieldNames the fieldNames to set
	 */
	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}
	/**
	 * @return the transModelToXMLMethodName
	 */
	public String getTransModelToXMLMethodName() {
		return transModelToXMLMethodName;
	}
	/**
	 * @param transModelToXMLMethodName the transModelToXMLMethodName to set
	 */
	public void setTransModelToXMLMethodName(String transModelToXMLMethodName) {
		this.transModelToXMLMethodName = transModelToXMLMethodName;
	}
	/**
	 * @return the compositeIdVO
	 */
	public CompositeIdVO getCompositeIdVO() {
		return compositeIdVO;
	}
	/**
	 * @param compositeIdVO the compositeIdVO to set
	 */
	public void setCompositeIdVO(CompositeIdVO compositeIdVO) {
		this.compositeIdVO = compositeIdVO;
	}	
}
