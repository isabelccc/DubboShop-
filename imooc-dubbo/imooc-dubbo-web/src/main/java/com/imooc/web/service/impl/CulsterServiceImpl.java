package com.imooc.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.item.service.ItemsService;
import com.imooc.order.service.OrdersService;
import com.imooc.web.service.CulsterService;

@Service("buyService")
public class CulsterServiceImpl implements CulsterService {
	
	final static Logger log = LoggerFactory.getLogger(CulsterServiceImpl.class);
	
	@Autowired
	private ItemsService itemService;

	@Autowired
	private OrdersService ordersService;
	
	@Override
	public void doBuyItem(String itemId) {
		// Reduce inventory
		itemService.displayReduceCounts(itemId, 1);
		
		// Create order
		ordersService.createOrder(itemId);
	}
	
	@Override
	public boolean displayBuy(String itemId) {
		
		int buyCounts = 5;
		
		// 1. Check inventory
		int stockCounts = itemService.getItemCounts(itemId);
		if (stockCounts < buyCounts) {
			log.info("Inventory remaining {} items, user demand {} items, insufficient inventory, order creation failed...", 
					stockCounts, buyCounts);
			return false;
		}
		
		// 2. Create order
		boolean isOrderCreated = ordersService.createOrder(itemId);
		
		// 3. After successful order creation, deduct inventory
		if (isOrderCreated) {
			log.info("Order created successfully...");
			itemService.displayReduceCounts(itemId, buyCounts);
		} else {
			log.info("Order creation failed...");
			return false;
		}
		
		return true;
	}
	
}

