package com.kkm.market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kkm.market.service.JoinService;

@Controller
public class JoinController {
	
	
	@Autowired JoinService joinService;

	@RequestMapping("joinUser")
	public String doJoin(Model model,HttpServletRequest request) {
		
		
		String name=request.getParameter("input_name");
		String id=request.getParameter("input_id");
		String pw=request.getParameter("input_pwd");
		String email=request.getParameter("input_email");
		String phone=request.getParameter("input_phone");
		
		
		Map param=new HashMap();
		
		param.put("name", name);
		param.put("id", id);
		param.put("pw", pw);
		param.put("email", email);
		param.put("phone", phone);
		param.put("user_img", "default.png");
		
		int n = joinService.insertUser(param);
		
		if(n>0) {
			return "redirect:joinSuccess";
		}
		else {
			return "redirect:joinFail";

		}
		
	}
	
	
	
	@RequestMapping(value="chk_id",produces = "application/text; charset=utf8")  //ajax 리턴시 한글처리
	@ResponseBody
	public String homeAjax(HttpServletRequest request) {

		String result="";

		if(joinService.chk_id((String)request.getParameter("id"))!=null) {
			System.out.println("아이디 발견 : "+joinService.chk_id((String)request.getParameter("id")).getId());
			result="아이디 중복";
		}
		else {
			System.out.println("아이디사용가능");
			result="아이디 사용가능";
		}
		

		return result;
		
	}
	
	
}
