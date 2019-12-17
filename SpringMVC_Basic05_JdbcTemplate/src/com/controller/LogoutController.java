package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {   //원래는 login 컨트롤러에 태워도 됨 

	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "loginForm";
	}
}
