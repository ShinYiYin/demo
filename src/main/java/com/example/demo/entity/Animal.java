package com.example.demo.entity;

public class Animal {
	
	private String name = "Fa";  //name設private，所以只會在此類別叫“Fa"
	
	protected String name1 = "Fa";

	//預設建構方法
	public Animal() {
		super();
		System.out.println("Animal 建構方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println(this.name + "正在吃");
	}
	
	public void sleep() {
		System.out.println(this.name + "正在睡");
	}
}
