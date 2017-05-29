package com.bear.dao;

import java.util.List;
import java.util.Map;

import com.bear.entity.User;

public interface UserDao {

	List<User> queryUser(Map<String, Object> qm);
	
	int queryUserCount(Map<String, Object> qm);
	
}
