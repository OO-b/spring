package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller {

	public IntroController() {
		System.out.println("IntroController 객체생성");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("IntroController 요청 실행 : handleRequest 함수 실행");

		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "bituser");
		mav.setViewName("intro");
		return mav;
	}

}
