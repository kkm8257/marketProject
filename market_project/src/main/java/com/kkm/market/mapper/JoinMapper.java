package com.kkm.market.mapper;

import java.util.Map;

import com.kkm.market.vo.UserVO;

public interface JoinMapper {

	
	public int insertUser(Map param);

	public UserVO chk_id(String id);

}
