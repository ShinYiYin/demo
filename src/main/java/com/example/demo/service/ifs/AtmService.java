package com.example.demo.service.ifs;

import com.example.demo.vo.AtmResponse;

public interface AtmService {

	//新建帳密
	public AtmResponse addInfo(String account, String pwd);
	
	//顯示帳號與餘額
	public AtmResponse getBalanceByAccount(String account, String pwd); 
	
	//更新密碼
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd);
	
	//存款
	public AtmResponse deposit(String account, String pwd, int amount);
	
	//提款
	public AtmResponse withdraw(String account, String pwd, int amount);
	
}
