package com.bear.entity;



/**
 * @author xiao
 * @since 2017-04-17
 */

public class CarStock  {


    /**
     * 主键ID
     */
	private int id;
    /**
     * 车牌号车辆编号
     */

	private String carNo;
    /**
     * 站点ID
     */

	private Integer stationId;
    /**
     * 车辆状态
     */

	private Integer carStatus;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(Integer carStatus) {
		this.carStatus = carStatus;
	}
	
	private String siteName;


	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
}
