package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//原本沒有這個library，故在build.gradle內新增 spring boot data jpa，就可以import @Table
//可以在左側Project and External Dependencies內找到spring-boot-starter-data-jpa-2.7.17.jar即是有安裝成功

@Entity  //可以想像成是媒介或容器，存取以下資料
@Table(name = "menu")
public class Menu {
	
	@Id  //表示此name是在資料表內的PK(primary key)。(單一PK 或 多個欄位可勾選為PK，稱複合型PK)
	@Column(name = "name") //資料庫的資料表內的欄位名稱
	private String name;  //在java自己定義的屬性(變數)名稱
	
	@Column(name = "price")
	private int price;
	
	public Menu() {
		super();
		
	}
	
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
