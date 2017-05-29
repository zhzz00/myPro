package com.bear.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.dao.UserDao;
import com.bear.dto.QueryUserListReq;
import com.bear.dto.QueryUserListRsp;
import com.bear.entity.User;
import com.bear.exception.HandelException;
import com.bear.service.sys.IUserService;
import com.google.common.collect.Maps;
@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userDao;
	@Override
	public QueryUserListRsp queryUserList(QueryUserListReq req) {
		Map<String, Object> qm = Maps.newHashMap();
		QueryUserListRsp r = new QueryUserListRsp();
		if(StringUtils.isNotBlank(req.getUserAccount())){
			qm.put("userAccount", req.getUserAccount());
		}
		qm.put("page", (req.getPage()-1) * req.getPageSize());
		qm.put("pageSize", req.getPageSize());
		try {
			List<User> users = userDao.queryUser(qm);
			int rows = userDao.queryUserCount(qm);
			r.setUsers(users);
			r.setRows(rows);
			if(StringUtils.isNotBlank(req.getExt())){
				r.setExt(req.getExt());
			}
		} catch (HandelException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HandelException("queryUserList is error", -30000);
		}
		return r;
	}

}
