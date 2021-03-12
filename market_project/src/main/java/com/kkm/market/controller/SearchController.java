package com.kkm.market.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kkm.market.mapper.ProductMapper;
import com.kkm.market.vo.ProductVO;

@Controller
public class SearchController {
	
	
	@Autowired 
	ProductMapper productMapper;
	
	@RequestMapping(value="getSearchList" ,produces = "application/json; charset=utf8", method=RequestMethod.POST) //application/json ¿Ã ¡ﬂø‰
	@ResponseBody
	public List<ProductVO> getSearchList(HttpServletRequest request,Model model) {
		
		String word = request.getParameter("word");
		System.out.println("word : "+word);
		 
		List<ProductVO> list =  productMapper.getSearchList(word);
		
		System.out.println("list"+list);
		model.addAttribute("search_list",list);
	 
		
		return list;
		
	}

	
	
	
}
