package com.example.test.modifiedsource.firstitem;

public enum AlertTypeEnum {

	TYPE_1(1, "Some description"), 
	TYPE_2(2, "Some description 2");

	private Integer id;
	private String description;

	private AlertTypeEnum(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return this.id;
	}

	public String getDescription() {
		return description;
	}

}
