package com.example.demo.vo;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;

public class AtmResponse {

	//RtnCode（寫法一）
//	private int code;
//	private String message;
	
	//RtnCode（寫法二）
	private RtnCode rtnCode;
	
	//將ATM拉進來，才可以取用(ATM為物件)
	private Atm atm;

	public AtmResponse() {
		super();
	}
	
	public AtmResponse(RtnCode rtnCode, Atm atm) {
		super();
		this.rtnCode = rtnCode;
		this.atm = atm;
	}

//	public AtmResponse(int code, String message, Atm atm) {
//		super();
//		this.code = code;
//		this.message = message;
//		this.atm = atm;
//	}

//	public int getCode() {
//		return code;
//	}

//	public void setCode(int code) {
//		this.code = code;
//	}

//	public String getMessage() {
//		return message;
//	}

//	public void setMessage(String message) {
//		this.message = message;
//	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}
	
	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}
	
}
