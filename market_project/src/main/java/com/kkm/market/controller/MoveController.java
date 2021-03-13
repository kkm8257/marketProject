package com.kkm.market.controller;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kkm.market.service.LoginService;
import com.kkm.market.service.MyInfoService;
import com.kkm.market.service.ProductService;
import com.kkm.market.vo.ProductVO;
import com.kkm.market.vo.UserVO;

@Controller
@RequestMapping("/")
public class MoveController {


	@Autowired
	ProductService productService;
	
	@Autowired
	MyInfoService myInfoSerivce;
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping("/")
	public String goHome(){
			
		return "home/home";
	}
	
	
	@RequestMapping("/join")
	public String goJoin(){
			
		return "join/join";
	}
	
	@RequestMapping("/login")
	public String goLogin(){
			
		return "login/login";
	}
	
	@RequestMapping("/joinSuccess")
	public String goJoinSuccess(){
			
		return "home/joinSuccess";
	}
	
	@RequestMapping("/joinFail")
	public String goJoinFail(){
			
		return "home/joinFail";
	}
	
	@RequestMapping("/saleView")
	public String goSaleView(){
			
		return "productView/saleView";
	}
	
	@RequestMapping("/myInfo")
	public String goMyInfo(HttpSession session, Model model) {
		
		
		UserVO userVO=loginService.getUserInfoById((String)session.getAttribute("session_id"));
		
		List<ProductVO> list = myInfoSerivce.getMyInfo((String)session.getAttribute("session_id"));
		model.addAttribute("market_list",list);
		model.addAttribute("user",userVO);
		
		return "myInfo/myInfo";
	}
	
	
	
	@RequestMapping(value="/productView"  ,method=RequestMethod.GET )
	public String goProductView(Model model,HttpServletRequest request){
		
		String market_idx=(String)request.getParameter("idx");
		
		ProductVO item = productService.getProductInfo(market_idx);
		
		
		//세자리 콤마 따로 처리
		DecimalFormat Commas = new DecimalFormat("#,###"); 
		String settingPrice = (String)Commas.format(item.getMarket_price());

		model.addAttribute("product",item);
		model.addAttribute("settingPrice",settingPrice);
		
		
		
		
		return "productView/productView";
	}
	
	
	@RequestMapping(value="/myInfo_productView"  ,method=RequestMethod.GET )
	public String goMyInfo_ProductView(Model model,HttpServletRequest request){
		
		String market_idx=(String)request.getParameter("idx");
		
		ProductVO item = productService.getProductInfo(market_idx);
		
		
		//세자리 콤마 따로 처리
		DecimalFormat Commas = new DecimalFormat("#,###"); 
		String settingPrice = (String)Commas.format(item.getMarket_price());

		model.addAttribute("product",item);
		model.addAttribute("settingPrice",settingPrice);
		
		
		
		
		return "productView/myInfoProductView";
	}
	
	
	@RequestMapping(value="/myInfo_productModify"  ,method=RequestMethod.GET )
	public String goMyInfo_ProductModify(Model model,HttpServletRequest request){
		
		String market_idx=(String)request.getParameter("idx");
		
		ProductVO item = productService.getProductInfo(market_idx);
		
		
		//세자리 콤마 따로 처리
		DecimalFormat Commas = new DecimalFormat("#,###"); 
		String settingPrice = (String)Commas.format(item.getMarket_price());

		model.addAttribute("product",item);
		model.addAttribute("settingPrice",settingPrice);
		
		
		
		
		return "productView/myInfoProductModifyView";
	}
	
	
	
}
