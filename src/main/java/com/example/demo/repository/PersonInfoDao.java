package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

//Dao 操作資料庫的方法
@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String>{
	
	//例如：findByCity在方法內沒有，故在此自定義方法，以小駝峰命名，避免多個屬性時會報錯
	//City是要對照屬性名稱 city，C大寫是因以小駝峰命名，若屬性名稱cityy，則要findByCityy
	public List<PersonInfo> findByCity(String city);
	
	//find 多個欄位屬性，用And 或Or 做串接
	public List<PersonInfo> findByNameAndCity(String name, String city);
	public List<PersonInfo> findByNameOrCity(String name, String city);

	//4.找出年紀大於輸入條件的所有個人資訊
	public List<PersonInfo> findByAgeGreaterThan(int age);
	
	//5.找出年紀小於等於輸入條件的所有個人資訊(依年齡由小到大排序)沒有指定排序就會依PK來排
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);
	
	//6.找到年齡小於輸入條件1或是大於輸入條件2的資訊
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1, int age2);
	
	//7.找到年紀介於2個數字之間(有包含) 的資訊(以年齡由大到小排序、只取前3筆資料)
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int age1, int age2);
	
	//8.取得 city 包含某個特定字的所有個人資訊
	public List<PersonInfo> findByCityContaining(String keyword);
	
	//9.找出年紀大於輸入條件以及city包含某個特定字的所有人資訊(依照年齡由大到小排序)
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String city);
	
}
