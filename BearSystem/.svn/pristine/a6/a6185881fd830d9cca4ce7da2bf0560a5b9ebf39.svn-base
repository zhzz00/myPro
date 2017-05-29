package com.bear.dao;


import java.util.List;
import java.util.Map;

import com.bear.entity.Order;

public interface OrderDao {

	Order queryOrderByCarcode(String carcode);
	
	int updateCarcodeStatus(String orderId);
	
	List<Order> queryOrder(Map<String, Object> qm);
	
	int queryOrderCount(Map<String, Object> qm);
}
