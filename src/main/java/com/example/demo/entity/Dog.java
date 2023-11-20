package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

//在類別class底下的屬性(宣告的變數)，其權限會設成私有private(封裝）僅在此class底下可存取，而public僅在此專案可存取。
//private要提供方法使其可以存取（右鍵source => Generate Getters and Setters)
//建構方法
public class Dog implements RunService{
	// 以下是‘屬性’
	private String name = "Apple"; // 也可以給予初始值

	private String color;

	private int age;

	// 預設建構方法 (可以由IDE幫忙產生，右鍵source => Generate Constructor from Superclass)
	public Dog() {
		super();

	}

	// 帶有屬性的建構方法 (可以由IDE幫忙產生，右鍵source => Generate Constructor using fields)，
	// 與下面setName等做的行為相同，但建構方法不用回傳值型態，且方法名稱Dog一定是類別名稱!!!
	// 帶有屬性的方法，上面的預設建構方法一定要產生!!! 與之後連資料庫有關
	public Dog(String name, String color, int age) {
		super(); // super用於繼承，一定是找到class Object
		this.name = name;
		this.color = color;
		this.age = age;
	}

	// 以下是IDE自動產生的‘方法‘(Generate Getters and Setters)
	public String getName() {
		return name;
		// return後一定要接一個同樣為String資料型態的屬性。
	}

	// setName：方法名稱，前面要有回傳值型態
	// (String name)：小括號內是放什麼資料型態的“參數”(紫色)，可想像是容器(可動態去接)，此容器要用在{}的實作區域內
	public void setName(String name) {
		this.name = name;
		// this是指這個dog class
		// 屬性name(藍色)會找最近的name，故要加this.以區分。如果參數名稱改取名叫：nameA(紫色)，此時屬性name(藍色)就可不用加this。
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 自定義方法(自己寫方法去set所有屬性)
	public void setAttributes(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}

	// 補充：相同方法名稱 或 資料型態(參數)個數 或 資料型態(參數)位置，其一改變就不會紅蚯蚓
	public void setAttributes(int age, String name, String color) {
		this.name = name;
		this.color = color;
		this.age = age;
	}

	// static
	public void setStatic() {

	}

	public static void setStatic1() {

	}

	@Override
	public void run() {
		System.out.println("狗在奔跑");
		
	}
}
