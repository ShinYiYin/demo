package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

//@Service 使spring boot託管實作，而非介面
@Service
public class MenuServiceImpl implements MenuService {

	// @: annotation
	// @Autowired可將被spring boots託管的物件拿來用，再給予屬性 屬性名稱

	// 專案對資料庫做連接
	@Autowired
	private MenuDao menuDao;

	// 單筆餐點
	@Override
	public Menu addMenu(Menu menu) {
		// menu不得為空且價格需大於零
		if (!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) {
			return null;
		}
		// menu餐點已存在，回傳null，否則當餐點名稱相同，價格不同時會直接更新價格，而非新增。
		if (menuDao.existsById(menu.getName())) {
			return null;
		}
//		Menu result = menuDao.save(menu);
//		return result;
		return menuDao.save(menu);

	}

	// 多筆餐點
	@Override
	public List<Menu> addMenuList(List<Menu> menuList) {
		for (Menu item : menuList) {
			if (!StringUtils.hasText(item.getName()) || item.getPrice() <= 0) {
				return null;
			}
		}
		return menuDao.saveAll(menuList);
	}

	// 修改餐點
	@Override
	public Menu updateMenu(Menu menu) {
		// 需先檢查項目是否存在，因JDA的save方法不存在項目就會新增
		// 避免existsById為null，先將menu.getName()進行hasText檢查
		if (!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) {
			return null;
		}
		// 反向寫法
		if (!menuDao.existsById(menu.getName())) {
			return null;
		}
		return menuDao.save(menu);
		// 正向寫法，因return null後續沒有要其他操作，在此可直接用正向寫法
//		if(menuDao.existsById(menu.getName())) {
//			return menuDao.save(menu);
//		}
//		return null;
	}

	// 查詢特定餐點價格
	@Override
	public Menu findByName(String name) {
		//可先進行判斷，在此亦可省略，因orElseGet若無，可直接回傳null。
//		if (!StringUtils.hasText(name)) {
//			return null;
//		}
		
		Optional<Menu> op = menuDao.findById(name);
		// isEmpty()相反是 isPresent()，isPresent()只能用在Optional類別
		//orElseGet有值時，回傳值，若無則回傳欲回傳的值，只能用在Optional類別
//		return op.orElseGet(null);
		
		if (op.isEmpty()) {
			return null;
		}
		return op.get();
		
		//三元式寫法 (只能用在if else二擇一時）
//		Menu menu = op.isEmpty()? null : op.get();
//		return menu;
		//再縮減
//		return op.isEmpty()? null : op.get();
	}

	// 查詢所有餐點價格
	@Override
	public List<Menu> findAll() {
		return menuDao.findAll();
	}

}
