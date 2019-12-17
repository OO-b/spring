package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

/*
 *  로그인 화면 : GET 요청 > loginForm
 *  로그인 처리 : POST 요청 > id, pwd > memberCheck 검증 > loginSuccess(빈페이지)
 *  
 *  조건 : 인증 성공하면 session 담기 > [기존 servlet 과 동일]
 * 
 *  public void test(HttpSession session){
 *    session.setAttribute("USERID", "hong")
 *  }
 * 
 */
@Controller
@RequestMapping("/login.do")
public class LoginController {
	//@Autowired memberfield 주입 가능 근데 권장사항 X 
	private MemberDAO memberdao;  

	@Autowired //by type 
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	//get방식은 로그인 화면 
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	//post방식은 인증체크 
	//membercheck dao 함수 호출해서 id랑 password 해서 
	//session.setAttribute("USERID", "hong") 세션담기 
	//이동은 true가 넘어오면 loginsuccess / false가 넘어오면 다시 로그인 폼으로 
	
	@RequestMapping(method=RequestMethod.POST)
   public String loginSubmit(String id, String pwd,HttpSession session) {
		
		String view = null;
		 try {
			boolean check = memberdao.memberCheck(id, pwd);
			
			if(check) {
				session.setAttribute("USERID", id);
				view = "loginSuccess";
				
			}else {
				view = "loginForm";
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return view;
	}
	
	
	public void test(HttpSession session){
		    session.setAttribute("USERID", "hong");
		 }

}











