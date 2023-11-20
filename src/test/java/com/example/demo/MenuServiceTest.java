package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@SpringBootTest // (classes = DemoApplication.class)通常自己會尋找可不加
public class MenuServiceTest {

	// @Autowired 是Autowired介面，非實作
	@Autowired
	private MenuService menuService;

	// for刪除資料
	@Autowired
	private MenuDao menuDao;

	@Test
	public void addMenuTest() {
		// name不符條件
		Menu result = menuService.addMenu(new Menu("", 120));
		Assert.isTrue(result == null, "addMenu error!!");
		// price = 0
		result = menuService.addMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "addMenu error!!");
		// 正常新增
		result = menuService.addMenu(new Menu("fish1", 120));
		Assert.isTrue(result != null, "addMenu error!!");
		// 新增已存在的餐點
		result = menuService.addMenu(new Menu("fish1", 150));
		Assert.isTrue(result == null, "addMenu error!!");
		// 刪除測試的資料(不會用在service直接去做刪除)
		menuDao.deleteById("fish1");
	}

	@Test
	public void updateMenuTest() {
		// name不符條件
		Menu result = menuService.updateMenu(new Menu("", 120));
		Assert.isTrue(result == null, "updateMenu error!!");
		// price = 0
		result = menuService.updateMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "updateMenu error!!");
		// 更新不存在的menu
		result = menuService.updateMenu(new Menu("fish1", 120));
		Assert.isTrue(result == null, "updateMenu error!!");
		// 正常新增後再更新
		result = menuService.addMenu(new Menu("fish1", 120));
		result = menuService.updateMenu(new Menu("fish1", 150));
		Assert.isTrue(result != null, "updateMenu error!!");
		Assert.isTrue(result.getPrice() == 150, "updateMenu error!!");
		// 刪除測試資料
		menuDao.deleteById("fish1");
	}

	@Test
	public void findByNameTest() {
		// name不符條件
		Menu result = menuService.findByName("");
		Assert.isTrue(result == null, "findByName error!!");
		//name不存在
		result = menuService.findByName("fish1");
		Assert.isTrue(result == null, "findByName error!!");
		//新增測試資料
		result = menuService.addMenu(new Menu("fish1", 120));
		result = menuService.findByName("fish1");
		Assert.isTrue(result != null, "findByName error!!");
		// 刪除測試資料
				menuDao.deleteById("fish1");
	}
}
