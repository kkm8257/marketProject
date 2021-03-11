package com.kkm.market.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkm.market.mapper.JoinMapper;
import com.kkm.market.vo.UserVO;

@Service
public class JoinService {
	
	
	@Autowired
	JoinMapper joinMapper;
	
	public int  insertUser(Map param) {
		

		return joinMapper.insertUser(param);		
		
	}

	public UserVO chk_id(String id) {
		
		return joinMapper.chk_id(id);
	}

	
}
