package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.Menu;

public interface MenuService {
	
	//定義方法 
	//單筆餐點
	public Menu addMenu(Menu menu); //回傳save後（新增的資料）結果，所以public後面接回Menu。也可以根據需求接布林值等。

	//多筆餐點
	public List<Menu> addMenuList(List<Menu> menuList);
	
	//修改餐點
	public Menu updateMenu(Menu menu);
	
	//查詢特定餐點價格
	public Menu findByName(String name);
	
	//查詢所有餐點價格
	public List<Menu> findAll();
}
