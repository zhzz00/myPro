package com.bear.dto;


public class AddCarReq extends BaseEntity{
	
	/**
     * 车牌号车辆编号
     */

	private String carNo;
    /**
     * 站点ID
     */

	private Integer stationId;

	public String getCarNo() {
		return carNo;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	

}
