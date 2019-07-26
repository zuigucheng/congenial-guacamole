package com.xuzebiao.cms.enums;

public enum Gender {
	FAMALE("女士"),
	MALE("先生");
	
	private String description;

	private Gender(String description) {
		this.description = description;
	}

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
