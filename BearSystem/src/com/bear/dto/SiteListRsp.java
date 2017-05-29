package com.bear.dto;

import java.util.List;

import com.bear.entity.Site;

public class SiteListRsp {

	private List<Site> siteList;
	
	private int rows;

	public List<Site> getSiteList() {
		return siteList;
	}

	public void setSiteList(List<Site> siteList) {
		this.siteList = siteList;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
}
