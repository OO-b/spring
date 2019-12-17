package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

@Controller
public class JoinController {  //child container안에있는 빈객체. MemberDAO도 child container안에있음 

	//회원가입 => DB작업 필요(DAO)
	//  --> memberDaoimple에 의존해야함 
	//memberfield 인터페이스 타입 : 객체의 생성과 조립을 별도 (어떠한 부품도 조립이 되어야함 - 표준화/다형성....>>interface필요!)
	
	private MemberDAO memberdao;  // 인터페이스로 씀 ! 스프링은 인터페이스를 ♡

	@Autowired //by type 
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}

	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String form() {
		
		return "joinForm"; //resolver에 의해 특정 view를 찾음. 
	}
	

	   // 주의사항 : parameter 를 보내지 않으면 문제 없다
	   // Default :  <a href="search/external.do">external.do</a><br>	
	   // @RequestParam(value="p" , defaultValue="1") int p)
	   // 그런데 : <a href="search/external.do?p">external.do</a><br>	가면
	   // Failed to bind request element: org.springframework.beans.TypeMismatchException: Failed to convert value of type [java.lang.String] to required type [int]; nested exception is java.lang.NumberFormatException: For input string: ""
	   
	   //1. 해결방법 : 무조건 값을 보낸다   age=0
	   //   @RequestParam(value="age") int age
	   
	   //2. @RequestParam(value="age" , required = false ) int age	
	  
	   //3. @RequestParam(value="age" , defaultValue = "1") Integer age	
	   //   Type입을 객체타입으로 받는다 	
	
	@RequestMapping(value="/join.do",method=RequestMethod.POST) //joinForm에서 name값과 dto이름이 같으면 그냥 dto로 받아도됨! (지금은 RequestParam써보기위함)
																//@RequestParam의 장점은 default값을 설정할수 있는 것 
																// !! 회원가입, 게시판 글쓰기는 : DTO생성 => parameter로 dto쓰는게 편함 
	public String submit(@RequestParam(value="id", required= true) String id,
			             @RequestParam(value="name") String name,
			             @RequestParam(value="pwd") String pwd,
			             @RequestParam(value="email",defaultValue= "1@1") String email,
			             @RequestParam(value="age", defaultValue="1") int age) {
		
		String view = null;
		boolean joinresult = memberdao.memberInsert(id, name, pwd, email, age);
		
		if(joinresult) {
			view = "joinSuccess";
		} else {
			view = "joinForm";
		}
		
		return view;
		
	}
	
	
	
	
}
