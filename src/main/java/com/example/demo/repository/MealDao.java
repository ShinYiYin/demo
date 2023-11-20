package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId>{

	//Spring data jpa @query (https://www.baeldung.com/spring-data-jpa-query)（並不在原本JPA提供方法內，故在此自建)
	//請參考4.4.5. Limiting Query Results 或是 5.1.3. Query Methods
	
	// findTop數字：限制搜尋結果回傳筆數 (依排序撈回資料筆數，依序是以PK的字母->接續欄位的字母）
	public List<Meal> findTop2ByName(String name); //限制回傳筆數為2筆，()內一定要給參數，否則在編譯階段就會報錯
	
	//findFirst數字：限制搜尋結果回傳筆數 (Top 或 First 兩者意思相同)
	public List<Meal> findFirst2ByName(String name);
	
	//orderBy：排序 => 原則上會預設ASC (ASC:由小到大，DESC:由大到小)
	//根據名字搜尋(findByName) ，其結果依照價格排序(OrderByPrice)
	public List<Meal> findByNameOrderByPrice(String name);
	
	//從原本某個欄位撈出，故不用參數
	//findAllOrderByPrice 編譯時就會報錯，console寫會希望給參數，但findAll不需給參數，故因語法關係要多加By。
	
	//預設ASC : findAllByOrderByPriceAsc()
	public List<Meal> findAllByOrderByPrice();
	
	//倒序 (只能D大寫)
	public List<Meal> findAllByOrderByPriceDesc();
	
	//比較大小
	// 1.大於：GreaterThan 2.大於等於：GreaterThanEqual
	// 3.小於：LessThan 4.小於等於：LessThanEqual
	public List<Meal> findByPriceGreaterThan(int price);
	
	//多個欄位(條件) And 或 Or (對於數字如果沒有寫成比較的範圍，如findByNameAndPrice，價格只寫200，此時會找不到有價格為200的chicken)
	public List<Meal> findByNameAndPriceGreaterThan(String name, int price);
	
	//containing (偏向模糊搜尋）
	public List<Meal> findByNameContaining(String name);
	//多個欄位(條件) (自動忽略大小寫，例如:搜尋條件打b或B，皆可搜尋到BBQ，但有另個IgnoreCase這個語法）
	public List<Meal> findByNameContainingAndCookingStyleContaining(String name, String cookingStyle);

	//between (用於連續區間）:有包含上下界的值
	public List<Meal> findByPriceBetween(int price1, int price2);
	public List<Meal> findByPriceBetweenOrderByPrice(int price1, int price2);
	
	//In
	public List<Meal> findByPriceIn(List<Integer> priceList);
	//NotIn
	public List<Meal> findByPriceNotIn(List<Integer> priceList);
}
