package com.example.demo.entity;

import java.io.Serializable;

@SuppressWarnings("serial") //忽略警告 （序列化）
public class MealId implements Serializable{

	private String name;
	
	private String cookingStyle;
	
	public MealId() {
		super();
	}
	
	public MealId(String name, String cookingStyle) {
		super();
		this.name = name;
		this.cookingStyle = cookingStyle;
	}
	
	//基本上用不到，但習慣生成一下
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCookingStyle() {
		return cookingStyle;
	}
	public void setCookingStyle(String cookingStyle) {
		this.cookingStyle = cookingStyle;
	}
}
