package com.example.demo.constants;

//Enum列舉
public enum RtnCode {
	
	//http status code
	//1.需建立constructor，否則SUCCESSFUL會報錯
	SUCCESSFUL(200, "Successful!"), //
	PARAM_ERROR(400, "Parameter Error!"), //
	ACCOUNT_EXISTED(400, "Account Existed!"), //
	ACCOUNT_NOT_FOUND(404, "Account Not Found!"),
	INSUFFICIENT_BALANCE(400, "Insufficient Balance!")
	;  

	private int code;
	
	private String message;

	//2.右鍵Source -> Generate constructor using Fields (* superClass預設建構方法不能用在Enum)
	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	//3.右鍵Source -> Generate Getter and Setters (只會用到getter)
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
