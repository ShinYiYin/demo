package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Dog;

public class StringTest {

	@Test
	public void stringTest() {
		String str = "ABC"; // 可直接賦值
		String str1 = new String("ABC"); // 通常不這樣寫
		String str2 = "ABC";
		System.out.println(str == str1); // false
		System.out.println(str == str2); // true
		System.out.println("===========================");
		// 字串比較‘內容值’=> equals
		System.out.println(str.equals(str1)); // true
		System.out.println(str.equals(str2)); // true
		System.out.println("===========================");
		// 字串比較‘忽略大小寫’=> equalsIgnoreCase （在java大小寫視為不同）
		String str3 = "aBC";
		System.out.println(str.equals(str3)); // false
		System.out.println(str.equalsIgnoreCase(str3)); // true
	}

	@Test
	public void stringTest1() {
		String str = "ABC";
		String str1 = "";
		String str2 = "  ";
		// length() 字串長度
		System.out.println(str.length()); // 3
		System.out.println(str1.length()); // 0
		System.out.println(str2.length()); // 2 (空白也算長度)
		System.out.println("===========================");
		// isEmpty() 是看字串的長度是否為0
		System.out.println(str1.isEmpty()); // true
		System.out.println(str2.isEmpty()); // false
		System.out.println("===========================");
		// isBlank() 是看字串是否長度只為0，或是 長度不為0但內容由全空白組成，其一條件滿足則回傳true
		System.out.println(str1.isBlank()); // true
		System.out.println(str2.isBlank()); // true
	}

	@Test
	public void stringTest2() {
		Dog dog = new Dog();
		String name = dog.getName();
		String color = dog.getColor();
		System.out.println(name); // 假設是Apple
		System.out.println(color); // Null
		System.out.println("===========================");
		// 當物件或類別其值是Null時，呼叫任何方法(.方法)時都會報錯 => NullPointerException!
//		System.out.println(name.length());  //5
//		System.out.println(color.length());  //會報錯
		// 判斷物件或類別其值是Null時，用‘==’進行比較。
		System.out.println(color == null); // true
		System.out.println("===========================");
		// 判斷物件或類別是否為空，null一定要先寫
		// 不能寫if(color.isBlank() || color == null ) 因為color是null，呼叫isBlank就會報錯
		if (color == null || color.isBlank()) {
			System.out.println("color是空字串");
		} else {
			System.out.println("color不是空字串");
		}
		System.out.println("===========================");
		// hasLength() 比 isEmpty 多去判斷 Null (有無長度）
		// hasText() 比 isBlank 多去判斷 Null （有無內容）較常用避免有null時報錯
		System.out.println(StringUtils.hasLength("   ")); // true
		System.out.println(StringUtils.hasText("   ")); // false
		System.out.println("===========================");
		color = "   ";
		if (color.isBlank()) {
			System.out.println("color沒有內容");
		} else {
			System.out.println("color有內容");
		}
		System.out.println("===========================");
		if (StringUtils.hasText(color)) {
			System.out.println("color有內容");
		} else {
			System.out.println("color沒有內容");
		}
		System.out.println("===========================");
		if (!StringUtils.hasText(color)) {
			System.out.println("color沒有內容");
		} else {
			System.out.println("color有內容");
		}
	}

	// 練習題 字元的搜尋 寫法1
	@Test
	public void stringTest3() {
		String str = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		String ans = "小龍女";
		int index = 0;
		int count = 0;
		while (str.indexOf(ans, index) != -1) {
			index = str.indexOf(ans, index) + ans.length();
			count++;
		}
		System.out.println(count);
	}

	// 練習題 字元的搜尋 寫法2
	@Test
	public void stringTest4() {
		String str = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		String ans = "小龍女";
		int count = 0;
		int index = 0;
		// 或是for(;;)無窮迴圈
		for (int i = 0; i < str.length(); i++) {
			// 終止條件：找不到就跳出迴圈
			if (str.indexOf(ans, index) == -1) {
				break;
			}
			count++;
			index = str.indexOf(ans, index) + ans.length();
		}
		System.out.println(count);
	}

	// 練習題 字元的搜尋 寫法3
	@Test
	public void stringTest5() {
		String str = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		String ans = "小龍女";
		int count = 0;
		int index = 0;
		for (; str.indexOf(ans, index) != -1;) {
			count++;
			index = str.indexOf(ans, index) + ans.length();
		}
		System.out.println(count);
	}

	// 取代
	@Test
	public void replaceTest() {
		String str = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		// replace 取代全部
		str = str.replace("小龍女", "小龍包");
		System.out.println(str);
		System.out.println("===========================");
		// replaceAll 取代全部(主要用在正規表達式)
		str = str.replaceAll("小龍包", "小龍湯包");
		System.out.println(str);
	}

	// 切割
	@Test
	public void splitTest() {
		String str = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		String[] array = str.split("小龍女");
		for (String item : array) {
			System.out.println(item);
		}
		System.out.println("===========================");
		String str1 = "ABCD";
		String[] array1 = str1.split("");
		for (String item : array1) {
			System.out.println(item);
		}
	}

	// 刪除
	@Test
	public void trimTest() {
		String str = "ABC DEF";
		String str1 = " ABC DEF ";
		System.out.println(str == str1); // false
		System.out.println(str.equals(str1)); // false
		str = str.trim();
		str1 = str1.trim();
		System.out.println(str); // ABC DEF
		System.out.println(str1); // ABC DEF
		System.out.println(str == str1); // false 記憶體位置
		System.out.println(str.equals(str1)); // true 值的內容 （字串內容比較請用equals!)
		System.out.println("=================================================");
		// 去掉空白 用空字串replace
		str = str.replace(" ", ""); // 如果"ABC DEF" 中間兩個空白，()前面也同樣打“ ”一個空格就可以了，會自己執行取代兩次而已。
		System.out.println(str);
	}

	// 擷取
	@Test
	public void substringTest() {
		String str = "神鵰俠侶是楊過與小龍女的故事";
		String subStr = str.substring(5);
		String subStr1 = str.substring(5, 11);
		System.out.println(subStr); // 楊過與小龍女的故事
		System.out.println(subStr1); // 楊過與小龍女
	}

	// stringBuffer 字串串接，但不是字串 （＋也是字串串接，但兩者有差異）
	// 補充：concat() 方法用于将指定的字符串参数连接到字符串上。
	@Test
	public void stringBufferTest() {
		StringBuffer sb = new StringBuffer("ABC");
		sb.append("DEF");
		sb.append("GGG");
		sb.append("AAA").append("BBB");
		System.out.println(sb); // ABCDEFGGGAAABBB
		System.out.println("=================================================");
		String str = "ABC" + "DEF" + "GGG" + "AAA" + "BBB"; // 也可以串接但會多新增五個記憶體空間
		System.out.println(str);
	}

	@Test
	public void stringBufferTest1() {
		StringBuffer sb = new StringBuffer("ABC");
		StringBuffer sb1 = new StringBuffer("ABC");
		System.out.println(sb.equals(sb1)); // false 是比較記憶體位置（因為本身不是字串）
		System.out.println("=================================================");
		System.out.println(sb.toString().equals(sb1.toString())); // true (需要轉字串才能比較)
	}

	// 練習題 把一個字串 ABACADEF 的最後一個 A 換成 W（寫法1）
	@Test
	public void stringTest6() {
		String str = "ABACADEF";
		int index = str.lastIndexOf("A"); // index = 4
		String lastString = str.substring(index); // lastString = ADEF
		lastString = lastString.replace("A", "W"); // lastString = WDEF
		str = str.substring(0, index) + lastString; // str.substring(0, index) = ABAC
		System.out.println(str);
	}

	// 練習題 把一個字串 ABACADEF 的最後一個 A 換成 W （寫法2）
	@Test
	public void stringTest7() {
		String str = "ABACADEF";
		int index = str.lastIndexOf("A"); // index = 4
		StringBuffer sb = new StringBuffer(str);
		sb.setCharAt(index, 'W');
		System.out.println(sb.toString());
	}

	// 練習題 判斷輸入的字串是否是迴文
	@Test
	public void stringTest8() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字：");
		String str = scan.next();
		StringBuffer sb = new StringBuffer(str); // StringBuffer不是字串，記得比較時要轉字串
		if (str.equals(sb.reverse().toString())) {
			System.out.println("是迴文");
		} else {
			System.out.println("不是迴文");
		}
	}

	// 練習題 判斷輸入的字串是否是迴文 (加判斷式）
	@Test
	public void stringTest9() {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			System.out.println("請輸入2個以上的文字：");
			String str = scan.next();
			if (str.length() <= 2) {
				continue;
			}
			StringBuffer sb = new StringBuffer(str);
			if (str.equals(sb.reverse().toString())) {
				System.out.println("是迴文");
			} else {
				System.out.println("不是迴文");
			}
			break;
		}
	}

	// 練習題 若輸入 List 是 [9, 9, 9, 9];輸出會是 [1, 0, 0, 0, 0]
	@Test
	public void stringTest10() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入數字");
		int inputInt = scan.nextInt();
		inputInt++;
		String str = String.valueOf(inputInt);
		String[] strArray = str.split("");
//		List<String> intList = new ArrayList<>(Arrays.asList(strArray));
//		System.out.println(intList);
		System.out.println(new ArrayList<>(Arrays.asList(strArray)));
		
	}
}
