package com.example.demo.entity;

public class HasA1 {
	
//	private String city;
//	
//	private String state;
//	
//	private String country;
	
//	private HasC c  //extendsTest1()
	private HasC c = new HasC(); //HasC是類別，給預設值new HasC()，要new來建立類別，才不會是預設值Null
	
	private String address;

	public HasC getC() {
		return c;
	}

	public void setC(HasC c) {
		this.c = c;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
	
}
