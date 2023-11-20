package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.Car;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Dog;
import com.example.demo.entity.HasA1;
import com.example.demo.entity.HasC;

public class ExtendsTest {

	@Test
	public void extendsTest(){
		Animal anim = new Animal();
		System.out.println("父類別 Animal name:" + anim.getName());
		anim.eat();       //呼叫方法 （因為void所以沒有回傳值，故不能印出東西，在此用呼叫的）
		anim.sleep();
		Bird bird = new Bird();
		bird.setName("小花");  //在啟動本身的建構方法前，父類別 Animal 的建構方法 會先被啟動
		System.out.println("子類別 Bird name:" + bird.getName());
		bird.eat();  //繼承父類別方法
		bird.sleep(); //@Override
		bird.flying();  //自己方法
		
		Cat cat = new Cat();
		
	}
	
	@Test
	public void extendsTest1(){
		HasA1 a1 = new HasA1();
		//透過類別HasA1 取得類別HasC中的私有屬性city
		a1.getC().getCity();
		//執行上述程式會報NullPointException，因為類別A1中的私有屬性C也是個類別，類別的預設值是Null
		//a1.getC()得到的值是Null，Null在呼叫方法時就會報錯
	}
	
	@Test
	public void extendsTest2(){
		HasA1 a1 = new HasA1();
		//透過類別HasA1 取得類別HasC中的私有屬性city
		String city = a1.getC().getCity();
		System.out.println(city);  //null
		//因為類別A1中的私有屬性C 有給預設值，故預設值就不會是Null
		//但類別C中的屬性一樣會是預設值，city是String，預設值是Null
	}
	
	@Test
	public void extendsTest3(){
		HasC c = new HasC();
		c.setCity("AAA");
		c.setCountry("BBB");
		c.setState("CCC");
	}
	
	//帶有屬性的建構方法 可更簡化上面extendsTest3
	@Test
	public void extendsTest4(){
		HasC c = new HasC("AAA", "BBB", "CCC");
		HasA1 a1 = new HasA1();
		a1.setC(c);
		a1.setAddress("DDD");
		System.out.println("city:" + a1.getC().getCity());
		System.out.println("country:" + a1.getC().getCountry());
		System.out.println("state:" + a1.getC().getState());
		System.out.println("address:" + a1.getAddress());
	}
	
	@Test
	public void extendsTest5(){
		Animal anim = new Animal();
		anim.eat();
		Bird bird = new Bird();
		bird.eat();
		Cat cat = new Cat();
		cat.eat();
		System.out.println("============================================");
		//宣告時都用 Animal 當作接收型態(外在的樣式，即父類別)，並呼叫 eat() 方法
		//接收的型態是父類別(Animal)，因此只能使用父類別提供的方法，所以上述的eat()皆是呼叫定義在Animal中的eat()
		//但子類別仍可以保有自己的實作內容
		Animal animm = new Animal();
		animm.eat();
		Animal birdd = new Bird();
		birdd.eat();
		Animal catt = new Cat();
		catt.eat();
	}
	
	@Test
	public void interfaceTest(){
		Car car = new Car();
		car.run();  //車子在跑
		Dog dog = new Dog();
		dog.run();  //狗在奔跑
		
	}
}
