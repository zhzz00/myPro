package com.bear.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Income {
	private Long orderId;
	private Long userId;
	private Double money;
	private String carNo;//车牌号
	private Date cretaeTime;
	private Long siteId;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCretaeTime() {
		return cretaeTime;
	}
	public void setCretaeTime(Date cretaeTime) {
		this.cretaeTime = cretaeTime;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
	
}
