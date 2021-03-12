package com.kkm.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkm.market.mapper.MyInfoMapper;
import com.kkm.market.mapper.ProductMapper;
import com.kkm.market.vo.ProductVO;

@Service
public class ProductService {

	
	@Autowired
	ProductMapper productMapper;
	
	public ProductVO getProductInfo(String market_idx) {
		return productMapper.getProductInfo(market_idx);
	}
	

	
}
