package com.core.vo.app;

public class CompositeIdVO implements java.io.Serializable{
	private String name;
	private Object compositeId;
	private String transCompositeVOToModelMethodName;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the compositeId
	 */
	public Object getCompositeId() {
		return compositeId;
	}
	/**
	 * @param compositeId the compositeId to set
	 */
	public void setCompositeId(Object compositeId) {
		this.compositeId = compositeId;
	}
	/**
	 * @return the transCompositeVOToModelMethodName
	 */
	public String getTransCompositeVOToModelMethodName() {
		return transCompositeVOToModelMethodName;
	}
	/**
	 * @param transCompositeVOToModelMethodName the transCompositeVOToModelMethodName to set
	 */
	public void setTransCompositeVOToModelMethodName(
			String transCompositeVOToModelMethodName) {
		this.transCompositeVOToModelMethodName = transCompositeVOToModelMethodName;
	}
}
