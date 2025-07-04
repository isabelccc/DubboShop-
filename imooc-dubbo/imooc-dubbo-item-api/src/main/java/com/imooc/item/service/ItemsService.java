package com.imooc.item.service;

import com.imooc.item.pojo.Items;

public interface ItemsService {

	/**
	 * @Description: Get item by item ID
	 */
	public Items getItem(String itemId);
	
	/**
	 * @Description: Query item stock
	 */
	public int getItemCounts(String itemId);
	
	/**
	 * @Description: Reduce stock after successful purchase
	 */
	public void displayReduceCounts(String itemId, int buyCounts);

}

