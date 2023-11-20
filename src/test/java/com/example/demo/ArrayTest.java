package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ArrayTest {

	@Test
	public void arrayTest() {
		int[] a = new int[5]; // new是給予一個記憶體空間
		System.out.println(a); // [I@38afe297
		System.out.println(a.length); // 5
		a[0] = 1;
		a[1] = 5;
		System.out.println(a); // [I@38afe297
		System.out.println("========================");
		// 宣告陣列的同時給予初始值
		int[] b = { 1, 3, 5, 7, 9 };
		System.out.println(b[2]); // 依索引號取陣列內的值
		// 使用forEach取陣列所有值
		for (int item : b) {
			System.out.println(item);
		}
	}

	@Test
	// List寫法：List <資料型態> 變數名稱 ＝ new ArrayList< > ( );
	public void listTest() {
		List<String> strList = new ArrayList<>();
		strList.add("A");
		strList.add("C");
		strList.add("B");
		strList.add("D");
		System.out.println(strList); // [A, C, B, D] List是有順序的(依加入的順序)
		System.out.println(strList.size()); // 長度：4
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i)); // 使用for迴圈取值：A C B D
		}
		System.out.println("=============================================");
		List<String> strList1 = List.of("A", "S", "D", "F"); // 長度無法更改 [A, S, D, F]
		List<String> strList2 = Arrays.asList("A1", "S1", "D1", "F1"); // 固定大小 [A1, S1, D1, F1]
		// 執行以下程式會報錯，因為用List.of() 或是 Arrays.asList() 所產生的List其大小固定，無法再增刪。
		// strList1.add("G");
		// strList2.add("G1");
		System.out.println("=============================================");
		// 因new ArrayList產生容納空間是動態的
		List<String> strList3 = new ArrayList<>(List.of("A", "S", "D", "F"));
		List<String> strList4 = new ArrayList<>(Arrays.asList("A1", "S1", "D1", "F1"));
	}
	
	@Test
	//資料型態
	public void listTest1() {
		int[] a = new int[3];
		Integer a1 = new Integer(5); //不建議使用，java準備棄用
		Integer a2 = 5; //預設是null，若null計算長度會報錯
		int a3 = 5;
		
	}

	@Test
	public void forEachTest() {
		List<String> strList = new ArrayList<>(List.of("A", "S", "D", "F"));
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i)); // 使用for迴圈取值：A S D F
		}
		System.out.println("=============================================");
		// forEach:遍歷，意思是指將List裡的每個項目從頭到尾一個一個取出。
		// for(資料型態 變數item是指List的每個項(例如跑第一次item = A)：取得List的對象)
		for (String item : strList) {
			System.out.println(item); // 使用forEach取值：A S D F
		}
		System.out.println("=============================================");
		// forEach -> (Lambda表達式)
		strList.forEach(item -> {
			System.out.println(item);
		});
	}
	
	@Test
	//練習題 找質數
	public void primeTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入一個數字：");
		int target = scan.nextInt();
		List<Integer> list = new ArrayList<>();
//		int count = 0;
		for(int i = 2; i < target; i++) {
			boolean isPrime = true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
//					count++;
					break;
				}
			}
			if(isPrime) {
				list.add(i);
			}
//			if(count > 0) {
//				list.add(i);
//			}
		}
		System.out.println(list);
	}
}
