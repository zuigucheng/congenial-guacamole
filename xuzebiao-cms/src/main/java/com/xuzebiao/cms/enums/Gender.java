package com.xuzebiao.cms.enums;


/**
 * <p>
 * 	性别枚举信息类
 * </p>
 * 
 * @author xuzebiao
 * @since 2019-07-26
 * 
 * 
 */

public enum Gender {
	
	//女士
	FAMALE("女士"),
	//男士
	MALE("先生");
	
	//信息描述
	private String description;

	//有参构造
	private Gender(String description) {
		this.description = description;
	}
	
	/**
	 * 获取枚举信息
	 *
	 */
	public String getDescription() {
		return description;
	}

	public String getName() {
		return name();
	}
	
	public int getOrdinal() {
		return this.ordinal();
	}
}
