package com.bear.web.site;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bear.dto.LoginReq;
import com.bear.dto.LoginRsp;
import com.bear.dto.ReturnVo;
import com.bear.exception.HandelException;
import com.bear.service.site.ISiteUserService;
import com.bear.utils.JsonUtil;
import com.bear.utils.ParametersCheckUtil;
import com.bear.web.BaseController;
@RestController
@RequestMapping("/siteUser")
public class SiteUserController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ISiteUserService service;
	
	@RequestMapping(value="/login",method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public ReturnVo<LoginRsp> login(@RequestBody String body){
		logger.info("user reg request param：" + body);
		LoginReq req=JsonUtil.getObject(LoginReq.class, body);
		if(null==req){
			throw new HandelException("Json消息非法", -8888);
		}
		ParametersCheckUtil.checkParams(req.getUserName(), "userName");
		ParametersCheckUtil.checkParams(req.getUserPwd(), "pwd");
		ReturnVo<LoginRsp> vo;
		try{
			LoginRsp rsp=service.login(req);
			vo=new ReturnVo<LoginRsp>("10000", rsp);
		}catch(com.bear.exception.HandelException e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<LoginRsp>(e.getCode()+"", e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<LoginRsp>("-9999"+"", e.getMessage());
		}
		
		return vo;
	}
}
