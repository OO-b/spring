package com.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	//요청당 필요한 함수 구현 
	//Cookie를 쓰는건 뷰단을 제어해서 쓰는게 아니라 필요한 객체를 파라미터로 받아야함 
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth", "1004"));
		//Servlet에서 사용한 방식과 동일함 
		//view단 넘어갈거 아니면, 그냥 여기서 끝내도 됨 함수도 void로 
		//view단을 넘어간다면?
		return "cookie/CookieMake";
	}
	
	
	@RequestMapping("cookie/view.do")
	//public String view(HttpServletRequest request) {getCookie}   - 이것도 가능하지만 이전방식
	//↓ Annotation으로 값 받아오는 방법 
	public String view(@CookieValue(value="auth", defaultValue="1000") String auth) {  
		//파라미터로 쿠키를 받을 수 있음. value는 내가 읽어올 쿠키값,(값이없다면) default value 정의가능
		//그걸 String auth에 담겠다. 
		System.out.println("클라이언트에서 read한 쿠키값 : " + auth);
		return "cookie/CookieView";
	}
}
