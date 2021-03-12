package com.kkm.market.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkm.market.mapper.JoinMapper;
import com.kkm.market.mapper.LoginMapper;
import com.kkm.market.vo.UserVO;

@Service
public class LoginService {
	
	
	@Autowired
	LoginMapper loginMapper;

	public UserVO checkLogin(Map param) {
		 return loginMapper.checkLogin(param);

	}

	public UserVO getUserInfoById(String id) {
		return loginMapper.getUserInfoById(id);
	}

}
