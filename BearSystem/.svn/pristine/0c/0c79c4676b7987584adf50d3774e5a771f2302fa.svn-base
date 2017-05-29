package com.bear.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.dao.SiteDao;
import com.bear.dto.AddSiteReq;
import com.bear.dto.AddSiteRsp;
import com.bear.dto.SiteListReq;
import com.bear.dto.SiteListRsp;
import com.bear.dto.UpdateSiteReq;
import com.bear.dto.UpdateSiteRsp;
import com.bear.entity.Site;
import com.bear.entity.SiteUser;
import com.bear.exception.HandelException;
import com.bear.service.sys.ISysSiteService;
import com.google.common.collect.Maps;
@Service
public class SysSiteServiceImpl implements ISysSiteService {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SiteDao dao;
	@Override
	public SiteListRsp querySite(SiteListReq req) throws HandelException {
		// TODO Auto-generated method stub
		SiteListRsp rsp=null;
		Map<String, Object> qm = Maps.newHashMap();
		qm.put("page", (req.getPage()-1) * req.getPageSize());
		qm.put("pageSize", req.getPageSize());
		qm.put("siteName", req.getSiteName());
		qm.put("siteStatus", req.getSiteStatus());
		List<Site> list=null;
		try{
			list=dao.querySiteList(qm);
			if(null==list||list.size()==0){
				throw new HandelException("无站点数据",-1004);
			}
			int count=dao.querySiteCount(qm);
			rsp=new SiteListRsp();
			rsp.setRows(count);
			rsp.setSiteList(list);
		}catch(HandelException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("query sitelist exception", e);
			throw new HandelException(e.getMessage(), -10004);
		}
		return rsp;
	}

	@Override
	@Transactional
	public AddSiteRsp addSite(AddSiteReq req) throws HandelException {
		// TODO Auto-generated method stub
		AddSiteRsp rsp=null;
		try{
			Site site=req.getSite();
			//添加站点，返回站点ID
			int siteId=dao.addSite(site);
			SiteUser siteUser=new SiteUser();
			siteUser.setSiteId(siteId);
			siteUser.setSiteUserName(req.getSiteUser());
			siteUser.setSiteUserPwd("123456");
			dao.addSiteUser(siteUser);
			rsp=new AddSiteRsp();
			rsp.setState("0");
		}catch(HandelException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("add site exception", e);
			throw new HandelException(e.getMessage(), -10005);
		}
		return rsp;
		
	}

	@Override
	public UpdateSiteRsp updateSite(UpdateSiteReq req) throws HandelException {
		// TODO Auto-generated method stub
		UpdateSiteRsp rsp=null;
		try{
			int count=dao.updateSite(req.getSite());
			if(count<0){
				throw new HandelException("编辑站点信息失败", -10006);
			}
			rsp=new UpdateSiteRsp();
			rsp.setState("0");
		}catch(HandelException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("update site exception", e);
			throw new HandelException(e.getMessage(), -10006);
		}
		return rsp;
	}

}
