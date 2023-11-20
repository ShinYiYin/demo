package com.example.demo;

import org.junit.jupiter.api.Test;

/* cmd + shift + o 可刪除與專案無關沒有使用的程式碼
   import org.springframework.boot.test.context.SpringBootTest;
   (=>因為目前不會用到@SpringBootTest，註解掉後import那行會顯示沒使用到，因此cmd + shift + o 可自動刪除該行。
*/

//@SpringBootTest
//權限：自己補上public（可以公開存取，但限定於此Demo專案）
public class DemoApplicationTests {
	/*
	結構： (為固定寫法！)
	＠Test：可以在Test此package執行方法，一定要加才可以單獨執行此方法
	void：執行方法的資料型態（回傳值型態）void是不回傳任何的值
	firstTest：方法名稱(自定義)，()：看需不需要帶參數，{}：實作區塊、邏輯區塊
	點兩下反白該方法，右鍵run as => JUnit test
	*/
	
	@Test
	public void firstTest() {
		int a = 1234567891;
//		String str = new String("ABC");
		String str = "ABC";
		String str1 = "123";
		System.out.println("str:" + str);
		//字串串接
		System.out.println(str + str1);
				
	}
}
