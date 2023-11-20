package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

//雙主鍵示範

@Entity 
@Table(name = "meal")
@IdClass(value = MealId.class) //有Id的屬性，集中至同個class管理，這裡要用‘value’
public class Meal {

	@Id
	@Column(name = "name")
	private String name;

	@Id
	@Column(name = "cooking_style")
	private String cookingStyle;

	@Column(name = "price")
	private int price;

	public Meal() {
			super();
			// TODO Auto-generated constructor stub
		}

	public Meal(String name, String cookingStyle, int price) {
			super();
			this.name = name;
			this.cookingStyle = cookingStyle;
			this.price = price;
		}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

}
