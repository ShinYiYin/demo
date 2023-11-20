package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;

//建立package名為repository，在此可放入操作資料庫的方法Dao，但因不需要實作，故在此是建立介面，名為MenuDao
//<T:改成class名稱Menu，ID:在Menu內有下 @Id 屬性的資料型態是String>
//interface無法new，故將 @Repository藉由spring boot託管，而託管類型叫repository。

@Repository
public interface MenuDao extends JpaRepository<Menu, String>{
	
	

}
