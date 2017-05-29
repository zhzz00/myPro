package com.bear.service.sys;

import com.bear.dto.LoginReq;
import com.bear.dto.LoginRsp;
import com.bear.exception.HandelException;

public interface IAdminService {

	public LoginRsp login(LoginReq req) throws HandelException;
}
