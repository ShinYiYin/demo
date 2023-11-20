package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.PersonInfo;

public interface PersonInfoService {
	
	public void addInfo(PersonInfo info);
	
	public void addInfoList(List<PersonInfo> infoList);

}
