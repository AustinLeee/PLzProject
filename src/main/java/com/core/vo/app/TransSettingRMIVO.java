package com.core.vo.app;

import java.io.Serializable;
import java.util.Map;

public class TransSettingRMIVO implements Serializable{
	private String serviceClassName = "";
	private String modelClassName = "";
	private String voClassName = "";	
	private String transModelToVOMethodName = "";
	private String transVOToModelMethodName = "";
	private Map parms = null;
	/**
	 * @return the serviceClassName
	 */
	public String getServiceClassName() {
		return serviceClassName;
	}
	/**
	 * @param serviceClassName the serviceClassName to set
	 */
	public void setServiceClassName(String serviceClassName) {
		this.serviceClassName = serviceClassName;
	}
	/**
	 * @return the modelClassName
	 */
	public String getModelClassName() {
		return modelClassName;
	}
	/**
	 * @param modelClassName the modelClassName to set
	 */
	public void setModelClassName(String modelClassName) {
		this.modelClassName = modelClassName;
	}
	/**
	 * @return the voClassName
	 */
	public String getVoClassName() {
		return voClassName;
	}
	/**
	 * @param voClassName the voClassName to set
	 */
	public void setVoClassName(String voClassName) {
		this.voClassName = voClassName;
	}
	/**
	 * @return the transModelToVOMethodName
	 */
	public String getTransModelToVOMethodName() {
		return transModelToVOMethodName;
	}
	/**
	 * @param transModelToVOMethodName the transModelToVOMethodName to set
	 */
	public void setTransModelToVOMethodName(String transModelToVOMethodName) {
		this.transModelToVOMethodName = transModelToVOMethodName;
	}
	/**
	 * @return the transVOToModelMethodName
	 */
	public String getTransVOToModelMethodName() {
		return transVOToModelMethodName;
	}
	/**
	 * @param transVOToModelMethodName the transVOToModelMethodName to set
	 */
	public void setTransVOToModelMethodName(String transVOToModelMethodName) {
		this.transVOToModelMethodName = transVOToModelMethodName;
	}
	/**
	 * @return the parms
	 */
	public Map getParms() {
		return parms;
	}
	/**
	 * @param parms the parms to set
	 */
	public void setParms(Map parms) {
		this.parms = parms;
	}
}
