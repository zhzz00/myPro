package com.bear.service.site;

import com.bear.dto.LoginReq;
import com.bear.dto.LoginRsp;
import com.bear.exception.HandelException;

public interface ISiteUserService {

	public LoginRsp login(LoginReq req) throws HandelException;
}
