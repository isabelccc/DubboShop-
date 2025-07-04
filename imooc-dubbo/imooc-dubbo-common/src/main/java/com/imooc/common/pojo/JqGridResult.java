package com.imooc.common.pojo;

import java.util.List;

/**
 * 
 * @Description: Used to return data format for jqGrid
 */
public class JqGridResult {
	
	private int page;			// Current page number
	private int total;			// Total number of pages
	private long records;		// Total number of records
	private List<?> rows;		// Content displayed in each row
	private Object userdata;	// User-defined data
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public long getRecords() {
		return records;
	}
	public void setRecords(long records) {
		this.records = records;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public Object getUserdata() {
		return userdata;
	}
	public void setUserdata(Object userdata) {
		this.userdata = userdata;
	}

}
