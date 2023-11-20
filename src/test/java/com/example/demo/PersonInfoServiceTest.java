package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@SpringBootTest
public class PersonInfoServiceTest {

	@Autowired
	private PersonInfoService personInfoService;
	
	@Autowired
	private PersonInfoDao personInfoDao;
	
	@Test
	public void addInfoTest() {
		personInfoService.addInfo(new PersonInfo("A123456780", "Lily", 30, "Taipei"));
	}
	
	@Test
	public void addInfoListTest() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("C123456789", "CCC", 32, "Kaohsiung"));
		list.add(new PersonInfo("D123456789", "DDD", 34, "Tainan"));
		personInfoService.addInfoList(list);
	}
	
	//原本save方法只能放入一筆資料，使用list => saveAll方法可一次放入多筆資料
	@Test
	public void daoSaveAllTest() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A123456789", "AAA", 28, "Kaohsiung"));
		list.add(new PersonInfo("B123456789", "BBB", 30, "Tainan"));
		personInfoDao.saveAll(list);
	}
	
	//findById，撈出來的資料為一物件，用於欲使用此id進行後續操作 
	@Test
	public void daoFindTest() {
		Optional<PersonInfo> infoOp = personInfoDao.findById("A123456789");  //指的是在Entity內有下@Id的屬性(PK)
		if(infoOp.isEmpty()) {
			System.out.println("Not found!!");
			return;
		}
		System.out.println(infoOp.get().getName());  //AAA
	}
	
	@Test
	public void daoFindTest2() {
		List<PersonInfo> list = personInfoDao.findAll();
		for(PersonInfo item: list) {
			System.out.println(item.getName());  //所有名字 Lily Lily AAA BBB CCC DDD
		}
	}
	
	//existsById，回傳為布林值，無後續操作僅判斷id是否存在 (例如：註冊帳號是否已存在），
	//因為在JPA所提供的save方法會後蓋前，故在此可用existsById先進行判斷。但在寫之後資料庫語法並不會有這樣情形存在
	@Test
	public void daoFindTest3() {
		boolean result = personInfoDao.existsById("A123456789");
		System.out.println(result);
	}
	
	@Test
	public void daoFindTest4() {
		List<PersonInfo> result = personInfoDao.findByCity("Taipei");
		for(PersonInfo item: result) {
			System.out.println(item.getName());  //Lily Lily
		}
		System.out.println(result.size()); //2筆
	}
	
	@Test
	public void daoFindTest5() {
		List<PersonInfo> result = personInfoDao.findByNameAndCity("Lily", "Taipei");
//		List<PersonInfo> result = personInfoDao.findByNameOrCity("AAA", "Tainan");
		for(PersonInfo item: result) {
			System.out.println(item.getId());  //A123456780 A123456787
		}
	}
	
	@Test
	public void compareTest() {
//		List<PersonInfo> res = personInfoDao.findByAgeGreaterThan(30);
//		List<PersonInfo> res = personInfoDao.findByAgeLessThanEqualOrderByAge(30);
//		List<PersonInfo> res = personInfoDao.findByAgeLessThanOrAgeGreaterThan(30, 32);
//		List<PersonInfo> res = personInfoDao.findTop3ByAgeBetweenOrderByAgeDesc(30, 34);
//		List<PersonInfo> res = personInfoDao.findByCityContaining("K");
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(28, "T");
		for(PersonInfo item : res) {
			System.out.println(item.getId() + "\t"+ item.getName() + "\t "+ item.getAge() + "\t"+ item.getCity());
		}
	}
}
