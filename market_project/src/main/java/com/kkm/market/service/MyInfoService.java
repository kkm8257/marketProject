package com.kkm.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkm.market.mapper.MyInfoMapper;
import com.kkm.market.vo.ProductVO;

@Service
public class MyInfoService {
	
	
	@Autowired
	MyInfoMapper infoMapper;

	public List<ProductVO> getMyInfo(String id) {
		return infoMapper.getMyInfo(id);
	}
	

	
}
