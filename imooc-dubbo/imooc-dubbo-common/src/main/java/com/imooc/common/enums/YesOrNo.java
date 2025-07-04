package com.imooc.common.enums;

/**
 * 
 * @Description: Yes or No Enum
 */
public enum YesOrNo {

	YES(1),		// Yes, has error
	NO(0); 		// No, no error
	
	public final int value;
	
	YesOrNo(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
