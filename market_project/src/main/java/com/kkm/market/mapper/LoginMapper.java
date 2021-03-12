package com.kkm.market.mapper;

import java.util.Map;

import com.kkm.market.vo.UserVO;

public interface LoginMapper {

	public UserVO checkLogin(Map param);

	public UserVO getUserInfoById(String id);


	

}
