package com.bear.dao;

import java.util.List;
import java.util.Map;

import com.bear.entity.CarStock;
import com.bear.entity.Site;
import com.bear.entity.SiteUser;

public interface SiteDao {

	/**
	 * 查询站点信息
	 * @param siteId
	 * @return
	 */
	Site querySiteInfo(int siteId);
	
	/**
	 * 查询站点可用车辆
	 * @param qm
	 * @return
	 */
	List<CarStock> queryCarBySite(Map<String,Object> qm);

	/**
	 * 查询可用车辆数量
	 * @param qm
	 * @return
	 */
	int queryCarBySiteCount(Map<String,Object> qm);
	
	
	/**
	 * 查询站点列表
	 * @param qm
	 * @return
	 */
	List<Site> querySiteList(Map<String,Object> qm);
	
	/**
	 * 查询站点列表数量
	 * @param qm
	 * @return
	 */
	int querySiteCount(Map<String,Object> qm);
	
	/**
	 * 添加站点
	 * @param site
	 * @return
	 */
	int addSite(Site site);
	/**
	 * 修改站点
	 * @param site
	 * @return
	 */
	int updateSite(Site site);
	

	int addSiteUser(SiteUser siteUser);
}
