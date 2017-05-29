package com.bear.web.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bear.dto.AddSiteReq;
import com.bear.dto.AddSiteRsp;
import com.bear.dto.OrderListReq;
import com.bear.dto.OrderListRsp;
import com.bear.dto.ReturnVo;
import com.bear.dto.SiteListReq;
import com.bear.dto.SiteListRsp;
import com.bear.dto.UpdateSiteReq;
import com.bear.dto.UpdateSiteRsp;
import com.bear.exception.HandelException;
import com.bear.service.sys.ISysSiteService;
import com.bear.utils.JsonUtil;
import com.bear.web.BaseController;
@RestController
@RequestMapping("/sysSite")
public class SysSiteController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private ISysSiteService service;
	@RequestMapping(value="/querySite",method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public ReturnVo<SiteListRsp> querySite(@RequestBody String body){
		logger.info("user reg request param：" + body);
		SiteListReq req=JsonUtil.getObject(SiteListReq.class,body);
		if(null==req){
			throw new HandelException("Json消息非法", -8888);
		}
		ReturnVo<SiteListRsp> vo;
		try{
			SiteListRsp rsp=service.querySite(req);
			vo=new ReturnVo("10000", rsp.getSiteList());
		}catch(HandelException e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<SiteListRsp>(e.getCode()+"", e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<SiteListRsp>("-9999"+"", e.getMessage());
		}
		
		return vo;
	}
	
	@RequestMapping(value="/addSite",method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public ReturnVo<AddSiteRsp> addSite(@RequestBody String body){
		logger.info("user reg request param：" + body);
		AddSiteReq req=JsonUtil.getObject(AddSiteReq.class,body);
		if(null==req){
			throw new HandelException("Json消息非法", -8888);
		}
		ReturnVo<AddSiteRsp> vo;
		try{
			AddSiteRsp rsp=service.addSite(req);
			vo=new ReturnVo<AddSiteRsp>("10000", rsp);
		}catch(HandelException e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<AddSiteRsp>(e.getCode()+"", e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<AddSiteRsp>("-9999"+"", e.getMessage());
		}
		
		return vo;
	}
	
	@RequestMapping(value="/updateSite",method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public ReturnVo<UpdateSiteRsp> updateSite(@RequestBody String body){
		logger.info("user reg request param：" + body);
		UpdateSiteReq req=JsonUtil.getObject(UpdateSiteReq.class,body);
		if(null==req){
			throw new HandelException("Json消息非法", -8888);
		}
		ReturnVo<UpdateSiteRsp> vo;
		try{
			UpdateSiteRsp rsp=service.updateSite(req);
			vo=new ReturnVo<UpdateSiteRsp>("10000", rsp);
		}catch(HandelException e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<UpdateSiteRsp>(e.getCode()+"", e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<UpdateSiteRsp>("-9999"+"", e.getMessage());
		}
		
		return vo;
	}
}
