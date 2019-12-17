package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{  //굳이 비교하자면, 여기 Controller는 서비스 

	public HelloController() {
		System.out.println("Hello Controller 객체생성 ^_^");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {  // doget, dopost 역할과 비슷
		System.out.println("helloController 요청 실행 : handleRequest 함수 실행");
		
		//업무 수행(게시판 목록보기, 글쓰기 처리.. 등)
		//데이터를 담고, view를 지정하는 역할을 함 
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "hong");  //request.setAttribute랑 같은 역할
		mav.setViewName("Hello"); // view 지정 
		
		return mav;   //리턴하는 방식이 forward방식임
	}

}
