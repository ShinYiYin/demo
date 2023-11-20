package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ConditionTest {

	@Test
	public void ifTest() {
		int a = 5;
		if (a > 5) {
			System.out.println("======");
		} else {
			System.out.println("++++++");
		}
	}

	// 同在 ConditionTest(作用域)內，ifTest(方法名稱)不能重複。
	@Test
	public void ifTest1() {
		int a = 5;
		if (a > 5) {
			System.out.println("======");
		} else if (a > 6) {
			System.out.println("++++++");
		} else {
			System.out.println("------");
		}
	}

	@Test
	public void switchTest() {
		int a = 95;
		int b = 95 / 10;
		double c = 95 / 10;
		double d = 95.0 / 10; // 成為浮點數的運算(只要其中有一為浮點數)，就會是9.5
		System.out.println(b); // 9
		System.out.println(c); // 9.0 因為java預設型態是int =>95、10是int，所以是int/int，出來結果是整數9，再使9為浮點數double，故輸出為9.0。
		System.out.println(d);
	}

	@Test
	public void scannerTest() {
		// Scanner：為‘物件’，可接收鍵盤的輸入。
		Scanner scan = new Scanner(System.in); // 黃蚯蚓是因為未關閉io(先不用管)
		System.out.println("請輸入文字：");
		String a = scan.next();
		System.out.println("輸入的文字是：" + a); // 輸入：ABC DEF，輸出：ABC (因為scanner以空白做為多次輸入)
	}

	@Test
	public void scannerTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字：");
		String a = scan.next();
		String b = scan.next();
		System.out.println("輸入的文字是：" + a + b); // 輸入：ABC DEF，輸出：ABCDEF
	}

	@Test
	public void scannerTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字：");
		String a = scan.nextLine(); // (多加Line，scanner以空白做為一次性輸入)
		System.out.println("輸入的文字是：" + a); // 輸入：ABC DEF，輸出：ABC DEF
	}

	@Test
	public void scannerTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入數字：");
		int a = scan.nextInt();
		System.out.println("輸入的數字是：" + a); // 輸入：ABC，會報錯。
	}

	@Test
	public void switchTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入成績：");
		int input = scan.nextInt();
		switch (input / 10) {
		// 當成績90以上或是100，等級為A。(兩個case內容相同，可合併)
		case 10:
		case 9:
			System.out.println("A");
			break; // 點選break，可看到switch也被反白，代表執行到break時，跳出switch。
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
			// break; 此break可寫可不寫
		}
	}
	
	//回家練習題：假設今天是星期Ｘ，輸入天數 days 後，可以回應所輸入的 days 後是星期幾
	@Test
	public void switchTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入今天星期幾");
		String inputWeekday = scan.next();
		int inputNum = 0;
		switch (inputWeekday) {
		case "一":
			inputNum = 1;
			break;
		case "二":
			inputNum = 2;
			break;
		case "三":
			inputNum = 3;
			break;
		case "四":
			inputNum = 4;
			break;
		case "五":
			inputNum = 5;
			break;
		case "六":
			inputNum = 6;
			break;
		case "天":
			inputNum = 7;
			break;
		}
		System.out.println("請輸入計算天數");
		int inputDay = scan.nextInt();
		String outputWeekday = "";
		switch ((inputNum+inputDay) % 7) {
		case 0:
			outputWeekday = "天";
			break;
		case 1:
			outputWeekday = "一";
			break;
		case 2:
			outputWeekday = "二";
			break;
		case 3:
			outputWeekday = "三";
			break;
		case 4:
			outputWeekday = "四";
			break;
		case 5:
			outputWeekday = "五";
			break;
		case 6:
			outputWeekday = "六";
			break;
		}
		System.out.printf("今天是星期%s，%d天後是星期%s", inputWeekday, inputDay, outputWeekday);
	}
	
	//老師講解:假設輸入都是數字，合併兩個switch寫法
	@Test
	public void switchTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入今天星期幾");
		int inputInt = scan.nextInt();
		String weekday = switchDay(inputInt); //方法使用時，不用給予資料型態
		System.out.println("請輸入計算天數");
		int days = scan.nextInt();
		String output = switchDay((inputInt+days) % 7);
		System.out.printf("今天是星期％s, %d後是星期%s", weekday, days, output);
	}
	
	//參數傳遞 (方法定義時，前面需給予資料型態）也就是輸入的值，而weekday是方法(switchDay)執行的結果，所以要在方法內去宣告。
	//回傳weekday，故將void改成String。此時方法會跳出紅蚯蚓“This method must return a result of type String”，故需return weekday(字串)。
	public String switchDay(int inputInt) {
		String weekday = "";
		switch (inputInt) {
		case 0:
			weekday = "天";
			break;
		case 1:
			weekday = "一";
			break;
		case 2:
			weekday = "二";
			break;
		case 3:
			weekday = "三";
			break;
		case 4:
			weekday = "四";
			break;
		case 5:
			weekday = "五";
			break;
		case 6:
			weekday = "六";
			break;
		}
		return weekday;
	}
}
