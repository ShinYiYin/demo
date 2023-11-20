package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;


@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	//專案對資料庫做連接
	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public void addInfo(PersonInfo info) {
		String id = info.getId();
		String pattern = "[A-Za-z][1-2]\\d{8}"; 
		if (StringUtils.hasText(id) && id.matches(pattern)) {
			personInfoDao.save(info);			
		}else {
			System.out.println("id error!!");
		}
		
	}

	@Override
	public void addInfoList(List<PersonInfo> infoList) {  //假設infoList:有10筆資料
		String pattern = "[A-Za-z][1-2]\\d{8}"; 
		//forEach檢查list內每筆資料，如果其中一筆資料錯誤便不會存入資料庫
		for(PersonInfo item: infoList) {
			String id = item.getId();
			//寫法一
			if (!(StringUtils.hasText(id) && id.matches(pattern))) {
				System.out.println("id error!!");
				return;
			}
			//寫法二
//			if (!StringUtils.hasText(id) || !id.matches(pattern)) {
//				System.out.println("id error!!");
//				return;
//			}
		}
		personInfoDao.saveAll(infoList);  //若放在for迴圈內會將10筆資料放10次，雖然id重複會覆蓋最終還是只有10筆，但我們目的希望能一次塞10筆
	}
	
}
