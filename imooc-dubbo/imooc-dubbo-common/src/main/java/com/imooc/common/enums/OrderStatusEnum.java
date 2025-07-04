package com.imooc.common.enums;

/**
 * 
 * @Description: Order Status
 */
public enum OrderStatusEnum {

	WAIT_PAY(10, "Pending Payment"),		// Pending payment
	PAYING(20, "Paying"),				// In the process of payment
	PAID(30, "Paid"),					// Payment completed
	PAID_FAILD(40, "Payment Failed"),	// Payment failed
	CANCELED(50, "Canceled"),			// Order canceled
	CLOSED(60, "Transaction Closed");	// Timeout without payment, transaction closed
	
	public final int key;
	public final String value;
	
	OrderStatusEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (OrderStatusEnum status : OrderStatusEnum.values()) {
			if (status.getKey() == key) {
				return status.value;
			}
		}
		return null;
	}
	 
	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
