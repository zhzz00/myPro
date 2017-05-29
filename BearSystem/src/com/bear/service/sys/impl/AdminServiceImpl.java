package com.bear.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.dao.AdminDao;
import com.bear.dto.LoginReq;
import com.bear.dto.LoginRsp;
import com.bear.entity.Admin;
import com.bear.exception.HandelException;
import com.bear.service.sys.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
	private AdminDao dao;
	@Override
	public LoginRsp login(LoginReq req) throws HandelException {
		// TODO Auto-generated method stub
		LoginRsp rsp=new LoginRsp();
		String userName=req.getUserName();
		String pwd=req.getUserPwd();
		Admin admin=dao.queryAdmin(userName, pwd);
		if(null==admin){
			throw new HandelException("当前用户不存在", -10001);
		}
		rsp.setId(admin.getId());
		
		rsp.setUserName(admin.getUserName());
		return rsp;
	}

}
