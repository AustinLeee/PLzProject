package com.core.vo.app;

import java.util.Date;

/**
 * Pos3gTemp generated by hbm2java
 */
public class MstTempSaveRMIVO extends BaseRMIVO {

	private long id;
	private Long version;
	private String userNo;
	private String xmlContent;
	private Date creationDate;
	private String processId;
	private String processDesc;
	private String processDetailDesc;
	private String tabLabel;
	
	public MstTempSaveRMIVO() {
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getXmlContent() {
		return this.xmlContent;
	}

	public void setXmlContent(String xmlContent) {
		this.xmlContent = xmlContent;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getProcessId() {
		return this.processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessDesc() {
		return this.processDesc;
	}

	public void setProcessDesc(String processDesc) {
		this.processDesc = processDesc;
	}

	public String getProcessDetailDesc() {
		return this.processDetailDesc;
	}

	public void setProcessDetailDesc(String processDetailDesc) {
		this.processDetailDesc = processDetailDesc;
	}

	/**
	 * @return the tabLabel
	 */
	public String getTabLabel() {
		return tabLabel;
	}

	/**
	 * @param tabLabel the tabLabel to set
	 */
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}
}
