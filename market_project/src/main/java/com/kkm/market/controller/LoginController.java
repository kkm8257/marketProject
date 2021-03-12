package com.kkm.market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kkm.market.service.LoginService;
import com.kkm.market.vo.UserVO;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	
	
	@RequestMapping(value="checkLogin",produces = "application/text; charset=utf8")  //ajax responsebody 까먹지말것  한글처리도 ㅇ
	@ResponseBody
	public String checkLogin(Model model,HttpServletRequest request,HttpSession session) {
		
		
		String id= request.getParameter("id");
		String pw=request.getParameter("pw");
		
		Map param=new HashMap();
		
		param.put("id",id);
		param.put("pw",pw);
		
		UserVO loginUser = loginService.checkLogin(param);
		
		if(loginUser!=null) {

			System.out.println("로그인 성공");
			session.setAttribute("session_ok", "ok");
			session.setAttribute("session_id",id);
			
			return "로그인 성공";
			
		}else {
			//로그인 실패시 처리 필요 session이 아니라 model에 담아서 처리
				System.out.println("로그인 실패");
			
			return "잘못된 로그인 정보입니다.";
			}
			

		}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("session_ok");
		session.removeAttribute("session_id");

		
		return "home/home";
		
	}
	

	
}
