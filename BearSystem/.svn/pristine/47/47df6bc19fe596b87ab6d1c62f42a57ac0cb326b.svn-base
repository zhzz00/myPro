package com.bear.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bear.dto.LoginReq;
import com.bear.dto.OrderListReq;
import com.bear.dto.OrderListRsp;
import com.bear.service.sys.IAdminService;
import com.bear.service.sys.IOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class MyTest {
	@Autowired
	private IOrderService service;
    
	@Test
	public void test(){
		OrderListReq req=new OrderListReq();
		req.setOrderStatus(0);
		req.setUserAccount("18607189366");
		OrderListRsp rsp=service.queryOrder(req);
	}
	
	}

	

