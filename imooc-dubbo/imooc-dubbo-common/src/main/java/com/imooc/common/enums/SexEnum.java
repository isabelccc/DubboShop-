package com.imooc.common.enums;

/**
 * 
 * @Description: Gender Enum
 */
public enum SexEnum {
	
	GIRL(0),		// Female
	BOY(1),		// Male
	SECRET(2);	// Secret	
	
	public final int value;
	
	SexEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
