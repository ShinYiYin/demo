package com.example.demo.entity;

public class TaipeiBank {
	
	private String branch;
	
	private String user;
	
	private int balance = 1000;
	
	

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public int saving(int amount) {
		//防呆：因int包含負值，故存款只能正值才計算
		if(amount > 0) {
			balance += amount;			
		}
		return balance;
	}
	
	public int withdraw(int amount) {
		//防呆：提款值>0以及避免餘額不足
		if(amount > 0 && balance >= amount) {
			balance -= amount;
		}
		return balance;
	}
	
}
