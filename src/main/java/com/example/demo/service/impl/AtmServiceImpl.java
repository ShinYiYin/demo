package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repository.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmDao atmDao;

	@Override
	public AtmResponse addInfo(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			// 寫法一
//			return new AtmResponse(RtnCode.PARAM_ERROR.getCode(), RtnCode.PARAM_ERROR.getMessage(), null);
			// 寫法二
			return new AtmResponse(RtnCode.PARAM_ERROR, null);
		}
		if (atmDao.existsById(account)) {
//			return new AtmResponse(RtnCode.ACCOUNT_EXISTED.getCode(), RtnCode.ACCOUNT_EXISTED.getMessage(), null);
			return new AtmResponse(RtnCode.ACCOUNT_EXISTED, null);
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd)));
//		return new AtmResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
		// 儲存完帳密後，不想回傳pwd的話（欲屏蔽就設一個空字串）
		res.setPwd("");
		return new AtmResponse(RtnCode.SUCCESSFUL, res);

	}

	@Override
	public AtmResponse getBalanceByAccount(String account, String pwd) {
		// 輸入帳號是否為空
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(RtnCode.PARAM_ERROR, null);
		}
		// Atm atm = atmDao.findByAccountAndPwd(account, pwd);錯誤寫法！不能直接用原生密碼查餘額
		// 帳號是否存在（存在就撈資料，此時因為要撈資料，故不用existById，此只會回傳布林值)
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(RtnCode.ACCOUNT_NOT_FOUND, null);
		}
		// findById(JPA原生方法)取得之後是被optional包住，為了將Atm此物件取出(Atm被optional包住)，所以要用get出來
		Atm res = op.get();
		// 密碼比對 (原生比對加密，不能在test用原生密碼去找，資料庫內是加密密碼)
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(RtnCode.ACCOUNT_NOT_FOUND, null);
		}
		res.setPwd("");
		return new AtmResponse(RtnCode.SUCCESSFUL, res);
	}

	@Override
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd) {
		// 輸入帳號密碼是否為空
		if (!StringUtils.hasText(account) || !StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPwd)) {
			return new AtmResponse(RtnCode.PARAM_ERROR, null);
		}
		// 帳號是否存在
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(RtnCode.ACCOUNT_NOT_FOUND, null);
		}
		Atm res = op.get();
		// 密碼比對
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(oldPwd, res.getPwd())) {
			return new AtmResponse(RtnCode.ACCOUNT_NOT_FOUND, null);
		}
		// set新加密密碼
		res.setPwd(encoder.encode(newPwd));
		// 儲存新加密密碼
		atmDao.save(res);
		// 屏蔽return的密碼設空字串
		res.setPwd("");
		return new AtmResponse(RtnCode.SUCCESSFUL, res);
	}

	@Override
	public AtmResponse deposit(String account, String pwd, int amount) {
		// 輸入帳號密碼是否為空
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || amount <= 0) {
			return new AtmResponse(RtnCode.PARAM_ERROR, null);
		}
		// 帳號是否存在
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(RtnCode.ACCOUNT_NOT_FOUND, null);
		}
		Atm res = op.get();
		// 密碼比對
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(RtnCode.ACCOUNT_NOT_FOUND, null);
		}
		res.setBalance(res.getBalance() + amount);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(RtnCode.SUCCESSFUL, res);

	}

	@Override
	public AtmResponse withdraw(String account, String pwd, int amount) {
		// 輸入帳號密碼是否為空
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || amount <= 0) {
			return new AtmResponse(RtnCode.PARAM_ERROR, null);
		}
		// 帳號是否存在
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(RtnCode.ACCOUNT_NOT_FOUND, null);
		}
		Atm res = op.get();
		// 密碼比對
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(RtnCode.ACCOUNT_NOT_FOUND, null);
		}
		//檢查餘額大於提款金額
		if (res.getBalance() < amount) {
			res.setPwd("");
			return new AtmResponse(RtnCode.INSUFFICIENT_BALANCE, res);
		}
		res.setBalance(res.getBalance() - amount);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(RtnCode.SUCCESSFUL, res);
	}

}
