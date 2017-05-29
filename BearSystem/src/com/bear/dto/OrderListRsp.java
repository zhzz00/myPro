package com.bear.dto;

import java.util.List;

import com.bear.entity.Order;

public class OrderListRsp {

	private List<Order> orderList;
	
	private int rows;

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
}
