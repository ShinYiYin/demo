package com.example.demo.entity;

public class Cat extends Animal{
	
	public void eat() {
		System.out.println(super.getName() + "邊吃邊玩");
	}
	
	public void sleep() {
		System.out.println(super.getName() + "邊睡邊玩");
	}
	
	public void barking() {
		System.out.println(super.getName() + "正在叫");
	}
}
