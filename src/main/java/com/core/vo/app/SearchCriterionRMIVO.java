package com.core.vo.app;

public class SearchCriterionRMIVO {
	private String fieldName = "";
	private String operator = "";
	private String value = "";
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
