package com.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 public class HelloController implements Controller
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception { 
	단점 : 컨트롤러가 하나의 요청만을 처리  요청이 10개라면, Controller 10개
           
    Annotation사용하면 method 단위로 매핑을 할 수 있다.
    결국 : 요청을 받는게 컨트롤러 단위가 아니라, 메소드 단위 
               즉, 하나의 컨트롤러가 다수의 요청을 처리할 수 있다.   > 대신 요청을 처리하는 함수 10개 생성 
               
    
       1. implements Controller 이렇게 사용하는 건 매핑단위가 클래스 
       2. @Controller 사용하면 > 함수단위 매핑 (매핑주소는? 어디로 갈까요?)
          @RequestMapping() 사용해서 주소 매핑
          >> HelloController >> bean 생성 (이제는 id값이 주소로 매핑되지 않아요.)       
 * */

@Controller
public class HelloController{
	
	@RequestMapping("/hello.do")   //<a href="hello.do">hello.do</a>
	public ModelAndView hello() {
		System.out.println("[hello.do start]");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", getGreeting());
		mv.setViewName("Hello");      //Hello만 쓴다는건 resolver를 사용하겠다는 거 
		return mv;
		
	}
	
	//필요하다면 일반함수는 그냥 만들어 쓰면 됩니다.
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data ="";
		if(hour >=6 && hour <= 10) {
			data ="학습시간";
		}else if(hour >=11 && hour <= 15) {
			data ="배고픈시간";
		}else if(hour >=16 && hour <= 18) {
			data ="졸린시간";
		}else {
			data="go home";
		}
		return data;
	}


	

}
