package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class LoopTest {
	// 9*9 乘法表
	@Test
	public void loopTest() {
		a:for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j==2) {
					break a; //跳出指名的迴圈（a為自定義參數名）
				}
				System.out.printf("%d * %d = %2d ", i, j, i * j);
			}
			System.out.println(); // 換行輸出
		}
	}
	
	//產生亂數
	@Test
	public void randomTest() {
		//方法一：使用Math類別
		//公式：（區間上限值 - 區間下限值 +1) + 區間下限值
		//例如： 1~99
		double random = Math.random()*(99-1+1)+1;
		//例如： 20~50
		double random1 = Math.random()*(50-20+1)+20;
		System.out.println("========================");
		
		//方法二：使用Random類別
		Random ran = new Random();
		//Random類別裡的 nextInt(整數i): 會產生 0~小於輸入整數i的值
		//例如: 1~99
		int a = ran.nextInt(99) +1;	
		//Random類別裡的 nextInt(整數1, 整數2): 會產生大於等於整數1，小於整數2的值
		//例如: 20~80(我們這個java沒有random generator
		//int b = ran.nextInt(20, 80);	
	}
	
	//練習題--猜數字
	@Test
	public void guessNumTest() {
		//輸入數字
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入數字：");
//		int input = scan.nextInt();
		//亂數產生1~99，轉換成整數。
		//要注意！int後面要括號，不然int就會先將最近的Math.random(=0.點多)轉成整數0 再+1，永遠只會產生答案1。
		int ans = (int)(Math.random()*(99-1+1))+1;
		//設定上下限
		int max = 99;
		int min = 1;
		//使用無窮迴圈
		for(;;) {
			System.out.printf("請在%d~%d之間輸入數字", min, max);
			int input = scan.nextInt();
			//排除輸入數字超過1~99
			if(input < min || input >max) {
				continue;
			}
			if(input == ans) {
				System.out.println("bingo");
				break;
			}
			//改變輸入範圍
			if(input > ans) {
				max = input;
			}else{
				min = input;
			}
		}
	}
}
