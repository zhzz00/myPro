package com.bear.service.site.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.dao.SiteUserDao;
import com.bear.dto.LoginReq;
import com.bear.dto.LoginRsp;
import com.bear.entity.SiteUser;
import com.bear.exception.HandelException;
import com.bear.service.site.ISiteUserService;
@Service
public class SiteUserServiceImpl implements ISiteUserService {
    @Autowired
	private SiteUserDao siteUserDao;
	@Override
	public LoginRsp login(LoginReq req) throws HandelException {
		// TODO Auto-generated method stub
		LoginRsp rsp=new LoginRsp();
		String userName=req.getUserName();
		String pwd=req.getUserPwd();
		SiteUser siteUser=siteUserDao.querySiteUser(userName, pwd);
		if(null==siteUser){
			throw new HandelException("当前用户不存在", -10001);
		}
		rsp.setId(siteUser.getId());
		rsp.setSiteId(siteUser.getSiteId());
		rsp.setUserName(siteUser.getSiteUserName());
		return rsp;
	}

}
