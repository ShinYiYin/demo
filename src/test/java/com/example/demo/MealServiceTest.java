package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;

@SpringBootTest
public class MealServiceTest {

	@Autowired
	private MealService mealService;
	
	@Autowired
	private MealDao mealDao;
	
	@Test
	public void addMeal() {
		mealService.addMeal(new Meal("beef", "BBQ", 180));
		mealService.addMeal(new Meal("beef", "fry", 150));
		mealService.addMeal(new Meal("pork", "fried", 220));
		mealService.addMeal(new Meal("chicken", "stew", 260));
		mealService.addMeal(new Meal("chicken", "BBQ", 120));
		mealService.addMeal(new Meal("chicken", "steam", 520));
	}

	@Test
	public void addMealTest() {
		// name不符條件
		Meal result = mealService.addMeal(new Meal("", "BBQ", 180));
		Assert.isTrue(result == null, "addMeal error!!");
		// cooking_style不符條件
		result = mealService.addMeal(new Meal("beef", "", 180));
		Assert.isTrue(result == null, "addMeal error!!");
		// price = 0
		result = mealService.addMeal(new Meal("beef", "BBQ", 0));
		Assert.isTrue(result == null, "addMeal error!!");
		// 正常新增
		result = mealService.addMeal(new Meal("beef", "BBQ", 180));
		Assert.isTrue(result != null, "addMeal error!!");
		// 再新增已存在的meal
		result = mealService.addMeal(new Meal("beef", "BBQ", 180));
		Assert.isTrue(result == null, "addMeal error!!");
		// 刪除測試資料
		mealDao.deleteById(new MealId("beef", "BBQ"));
	}
	
	@Test
	public void limitTest() {
		List<Meal> res = mealDao.findFirst2ByName("chicken");
		Assert.isTrue(res.size() == 2, "find limit error!!");
		List<Meal> res1 = mealDao.findTop2ByName("chicken");
		Assert.isTrue(res1.size() == 2, "find limit error!!"); //BBQ、steam
	}
	
	@Test
	public void orderByTest() {
//		List<Meal> res = mealDao.findByNameOrderByPrice("chicken");
//		List<Meal> res = mealDao.findAllByOrderByPrice();
		List<Meal> res = mealDao.findAllByOrderByPriceDesc();
		for(Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ":" + item.getPrice());
		}
	}
	
	@Test
	public void compareTest() {
//		List<Meal> res = mealDao.findByPriceGreaterThan(200);
		List<Meal> res = mealDao.findByNameAndPriceGreaterThan("chicken", 200);
		for(Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ":" + item.getPrice());
		}
	}
	
	@Test
	public void containingTest() {
//		List<Meal> res = mealDao.findByNameContaining("e");
		List<Meal> res = mealDao.findByNameContainingAndCookingStyleContaining("e", "b");
		for(Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ":" + item.getPrice());
		}
	}
	
	@Test
	public void betweenTest() {
//		List<Meal> res = mealDao.findByPriceBetween(120, 260);
		List<Meal> res = mealDao.findByPriceBetweenOrderByPrice(120, 260);
		for(Meal item: res) {
			System.out.println(item.getName() + item.getCookingStyle() + ":" + item.getPrice());
		}
	}
	
	@Test
	public void inTest() {
//		List<Meal> res = mealDao.findByPriceIn(new ArrayList<>(List.of(100, 120, 150, 180, 200)));
		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(100, 120, 150, 180, 200)));
		for(Meal item: res) {
			System.out.println(item.getName() + item.getCookingStyle() + ":" + item.getPrice());
		}
	}
}
