package com.bear.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.dao.OrderDao;
import com.bear.dto.OrderListReq;
import com.bear.dto.OrderListRsp;
import com.bear.entity.Order;
import com.bear.exception.HandelException;
import com.bear.service.sys.IOrderService;
import com.google.common.collect.Maps;
@Service
public class OrderServiceImpl implements IOrderService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OrderDao dao;

	@Override
	public OrderListRsp queryOrder(OrderListReq req) throws HandelException {
		// TODO Auto-generated method stub
		OrderListRsp rsp=null;

		Map<String, Object> qm = Maps.newHashMap();
		qm.put("page", (req.getPage()-1) * req.getPageSize());
		qm.put("pageSize", req.getPageSize());
		qm.put("userAccount", req.getUserAccount());
		qm.put("orderStatus", req.getOrderStatus());
		
		
		List<Order> list=null;
		try{
			list=dao.queryOrder(qm);
			if(null==list || list.size()==0){
				throw new HandelException("无订单数据！",-10002);
			}
			int count = dao.queryOrderCount(qm);
			rsp=new OrderListRsp();
			rsp.setOrderList(list);
			rsp.setRows(count);
		}catch(HandelException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("query orderlist exception", e);
			throw new HandelException(e.getMessage(), -10003);
		}
		return rsp;
	}
}
