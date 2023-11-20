package com.example.demo;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.Dog;
import com.example.demo.entity.TaipeiBank;

public class ClassTest {
	@Test
	public void classTest0() {
		int x = 5;
		System.out.println(x);
		System.out.print(x + "\n"); // \n (換行符號)
		System.out.printf("x = %d", x);
		System.out.println("");

		int y; // "int"是基本資料型態
		long z;
		y = 103;
		System.out.println("列印103的值 \t" + y); // \t (縮排)
		y = 0b111;
		System.out.println("列印0b111的值 \t" + y);
		z = 022;
		System.out.println("列印022的值 \t" + z);
		z = 0x2B;
		System.out.println("列印0x2B的值 \t" + z);

		String str = "x"; // String
		System.out.println(str);
		
		String str1 = new String(); // 建立一個新的空間放字串
		System.out.println(str1);
	}
	
	@Test
	public void classTest() {
		//類別宣告 並import
		Dog dog = new Dog();
		//取屬性的值（透過get方法來取得dog類別的屬性）
		String name = dog.getName(); //null
		System.out.println(name); //null
		dog.setName("Lily"); //在呼叫setName方法時，會將“Lily”放入setName方法內的參數(紫色的name)
		name = dog.getName();
		System.out.println(name); //Lily
	}
	
	@Test
	public void classTest1() {
		Dog dog = new Dog();
		dog.setAttributes("yellow", "Lily", 2);
	}
	
	//練習題 存提款
	@Test
	public void classTest2() {
		TaipeiBank bank = new TaipeiBank();
		//Assert 判斷 正確與否 (當比對結果是false，就會跑後面字串）
		Assert.isTrue(bank.getBalance() == 1000, "saving error!");
		System.out.println(bank.getBalance()); //1000
		
		bank.saving(-500);
		Assert.isTrue(bank.getBalance() == 1000, "saving error!");
//		System.out.println(bank.getBalance()); //1000
		
		bank.saving(500);
		Assert.isTrue(bank.getBalance() == 1500, "saving error!");
//		System.out.println(bank.getBalance()); //1500
	}
	
	@Test
	public void classTest3() {
		TaipeiBank bank = new TaipeiBank();
		Assert.isTrue(bank.getBalance() == 1000, "saving error!");
		System.out.println(bank.getBalance()); //1000
		
		bank.withdraw(-500);
		Assert.isTrue(bank.getBalance() == 1000, "saving error!");
//		System.out.println(bank.getBalance()); //1000
		
		bank.withdraw(500);
		Assert.isTrue(bank.getBalance() == 500, "saving error!");
//		System.out.println(bank.getBalance()); //500
	}
	
	@Test
	public void classTest4() {
		Dog dog = new Dog();
		dog.setName("Lily");
		dog.setColor("blue");
		dog.setAge(2);
		System.out.println("====================");
		//帶有屬性的預設建構方法可減少程式碼
		Dog dogg = new Dog("QQQ", "GGG", 3);   
		System.out.println("====================");
	}

	//static
	@Test
	public void classTest5() {
		Dog dog = new Dog();
		dog.setStatic();  //一般方法的呼叫，必須要先把類別 new出來
		Dog.setStatic1();  //static方法的呼叫，直接用類別名稱.static 方法
		System.out.println("=========================================");
		Math.random();  //public static double random() 
		Random ran = new Random();
		ran.nextInt();   //public int nextInt()
		System.out.println("=========================================");
		//final
		int aaa = 100;
		aaa = 200;
		final int bbb = 50;  //被 final 修飾的變數只能進行一次初始化
//		bbb = 100;
	}
}
