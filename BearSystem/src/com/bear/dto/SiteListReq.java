package com.bear.dto;

public class SiteListReq {

	private String siteName;
	private Integer siteStatus;
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public Integer getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(Integer siteStatus) {
		this.siteStatus = siteStatus;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	private Integer page = 1;//当前页
	private Integer pageSize = 10;//每页显示行数
}
