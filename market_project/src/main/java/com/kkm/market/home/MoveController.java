package com.kkm.market.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MoveController {

	
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
	
	
}
