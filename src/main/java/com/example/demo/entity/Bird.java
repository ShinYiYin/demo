package com.example.demo.entity;

public class Bird extends Animal {
	
	//HAS-A 關係-聚合
	//Bird類別的屬性(成員變數:private TaipeiBank bank)其實是由另一個類別(TaipeiBank)所組成，此時我們可以稱”A HAS-A B(或A has a B)”
	//假設在Bird內需要定義以下三個屬性，但之前在TaipeiBank已有定義過這三個屬性，就可以直接從TaipeiBank來取代，以減少程式碼。
	private TaipeiBank bank;
	
//	private String branch;
//	private String user;
//	private int balance = 1000;

	// 預設建構方法
	public Bird() {
		super();
		System.out.println("Bird 建構方法");
	}

	// @Override:覆寫 或 重新定義。指父子類別有相同方法時(名稱加參數個數、位置)，子類別對此方法重新定義自己的實作內容
	// (在繼承這邊@Override可加可不加，但習慣會加，較清楚)
	@Override
	public void eat() {
		System.out.println(super.getName() + "邊吃邊玩");
	}

	@Override
	public void sleep() {
		System.out.println(super.getName() + "邊睡邊玩");
	}

	public void flying() {
		System.out.println(super.getName() + "正在飛"); // 用super可以取得父類別'公開'的方法
	}

}
