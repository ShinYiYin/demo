package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

//implements RunService後，Car出現紅蚯蚓“The type Car must implement the inherited abstract method RunService.run()”
//對此點選Add unimplemented methods，即可自動幫我們生成run()
public class Car implements RunService{

	@Override
	public void run() {
		System.out.println("車子在跑");
		
	}

	
}
