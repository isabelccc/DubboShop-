package com.imooc.order.service;

import com.imooc.order.pojo.Orders;

public interface OrdersService {

	/**
	 * @Description: Query order by order ID
	 */
	public Orders getOrder(String orderId);
	
	/**
	 * @Description: Create order
	 */
	public boolean createOrder(String itemId);

}

