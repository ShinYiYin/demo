package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class RegexpTest {
	
	@Test
	public void regexpTest(){
		String str = "0912-345-678";
//		String pattern = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d";
//		String pattern = "\\d{4}-\\d{3}-\\d{3}";  //大括號{}處理重複出現次數
		String pattern = "\\d{4}(-\\d{3}){2}";  //小括號()分組
		//matches() 比對格式
		System.out.println(str.matches(pattern)); //true
	}
	
	//區域號碼
	@Test
	public void regexpTest2(){
		String str ="(02)12345678";
//		String pattern = "(\\d{2})\\d{8}"; //格式：2碼8碼，不包含()，()只是分組用
		String pattern = "\\(\\d{2}\\)\\d{8}"; //格式：(2碼)8碼，包含()
		System.out.println(str.matches(pattern));
	}
	
	//練習
	@Test
	public void regexpTest3(){
		String pattern0  = "\\(\\d{2}\\)\\d{8}";  //格式：(2碼)8碼，包含()
		String pattern1  = "\\(\\d{2}\\)\\d{7}";  //格式：(2碼)7碼，包含()
		String pattern2  = "\\d{2}-\\d{8}";  //格式：2碼-8碼
		String pattern3  = "\\d{2}-\\d{7}";  //格式：2碼-7碼
		
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入電話");
		System.out.println("電話格式為：(區域2碼)電話號碼7碼或8碼");
		System.out.println("電話格式為：區域2碼-電話號碼7碼或8碼");
		String input = scan.next();
		if(input.matches(pattern0) || input.matches(pattern1) 
				|| input.matches(pattern2) || input.matches(pattern3)) {
			System.out.println(input + "符合格式");
		} else {
			System.out.println(input + "不符合格式");
		}	
	}
	
	//管道 | 或 || (一個或兩個，且旁邊不可留空白)
	//大括號{}設定比對次數區間
	//可將上面練習的寫法pattern0及pattern1進行合併如以下
	@Test
	public void regexpTest4(){
//		String patternA = "\\(\\d{2}\\)\\d{7}||\\(\\d{2}\\)\\d{8}"; //(02)1234567 or (02)12345678
//		String patternB = "\\(\\d{2}\\)(\\d{7}||\\d{8})";
		
		//patternA、patternB 整合成 patternC
//		String patternC = "\\(\\d{2}\\)\\d{7,8}";
//		String patternD = "\\d{2}-\\d{7,8}";
		
		//patternC、patternD 整合成 patternE
		String patternE = "(\\(\\d{2}\\)||\\d{2}-)\\d{7,8}";
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入電話");
		System.out.println("電話格式為：(區域2碼)電話號碼7碼或8碼");
		System.out.println("電話格式為：區域2碼-電話號碼7碼或8碼");
		String input = scan.next();
		if(input.matches(patternE)) {
			System.out.println(input + "符合格式");
		} else {
			System.out.println(input + "不符合格式");
		}
	}
	
	//練習 身分證字號檢查
	@Test
	public void regexpTest5(){
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入身分證字號");
		String input = scan.next();
		String pattern = "[A-Za-z][1-2]\\d{8}";
		if(input.matches(pattern)) {
			System.out.println(input + "符合格式");
		} else {
			System.out.println(input + "不符合格式");
		}
	}
	
	//練習 身分證字號檢查(排除六都ABDEFH)
	@Test
	public void regexpTest6(){
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入身分證字號");
		String input = scan.next();
		String pattern = "[A-Za-z&&[^ABDEFHabdefh]][1-2]\\d{8}";
		if(input.matches(pattern)) {
			System.out.println(input + "符合格式");
		} else {
			System.out.println(input + "不符合格式");
		}
	}
}
