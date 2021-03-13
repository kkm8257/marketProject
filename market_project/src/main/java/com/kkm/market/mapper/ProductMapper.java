package com.kkm.market.mapper;

import java.util.List;

import com.kkm.market.vo.ProductVO;

public interface ProductMapper {

	public ProductVO getProductInfo(String market_idx);

	
	public List<ProductVO> getSearchList(String word);


	public int setNewItem(ProductVO productVO);


	public int deleteProduct(int idx);


	public int modifyProduct(ProductVO productVO);


}
