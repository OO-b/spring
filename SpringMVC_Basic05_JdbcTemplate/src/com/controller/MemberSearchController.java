package com.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.MemberDAO;
import com.model.MemberVO;

/*
 * 
 * GET , POST 
 * check.do
 * 화면 : memberSearch.jsp
 * 처리 : memberResult.jsp
 * 
 * result 처리할때 ModelAndView를 리턴하거나, String 리턴하는 방식이있음 선택해서 하기 
 * public ModelAndView submit(){}
 * public String submit(Model model){} 
 * selectMemberById(id) 함수 사용
 */

@Controller
public class MemberSearchController {
	
	private MemberDAO memberdao;  

	@Autowired //by type 
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	/*
	@RequestMapping(value="/check.do" , method=RequestMethod.POST)
	public String submit(String id, Model model) throws SQLException {
		MemberVO membervo = memberdao.selectMemberById(id);
		model.addAttribute("membervo",membervo);
		String view = null;
		if(membervo != null) {
			view = "memberResult";
		}else {
			view = "memberSearch";
		}
		return view; 
	}
	*/
	
	
	
	@RequestMapping(value="/check.do" , method=RequestMethod.GET)
	public ModelAndView searchForm() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("memberSearch");
		
		return model;
	}
	
	
	@RequestMapping(value="/check.do" , method=RequestMethod.POST)
	public ModelAndView searchSubmit(String id) {
		MemberVO member =null;
		try {
		 member = memberdao.selectMemberById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		
		ModelAndView model = new ModelAndView();
		model.addObject("membervo", member);  //request.setAttribute랑 같은 역할
		model.setViewName("memberResult"); // 
		
		if(member != null) {
			model.setViewName("memberResult");
		}else {
			model.setViewName("memberSearch");
		}
		
		return model;
		
	}
}







