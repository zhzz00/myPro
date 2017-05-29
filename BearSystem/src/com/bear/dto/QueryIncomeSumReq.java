package com.bear.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class QueryIncomeSumReq extends BaseEntity{
	@ApiModelProperty(required = true, value = "用户的Id")
	private Long userId;
	private Long siteId;
	private String startTime;
	private String endTime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
}
