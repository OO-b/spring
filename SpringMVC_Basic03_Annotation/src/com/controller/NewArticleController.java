package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

/*클라이언트가 서버한테 요청을 보내는 방식
 
  1. 화면주세요. (글쓰기, 로그인화면)              write.do
  2. 처리해주세요. (로그인완료처리, 글쓰기 완료처리)   writeok.do
  
    요청이 /article/newArticle.do 요청 주소가 하나 
    화면을 달라는건지, 처리해달라는건지 알 수 없음 
  GET방식으로, POST방식으로 온거에따라 달라질 수 있음. 
  
  /article/newArticle.do >> 전송방식이 "GET"방식이면, '화면주세요' 
  /article/newArticle.do >> 전송방식이 "POST"방식이면, '화면처리해주세요'

 */


@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {

	//NewArticleController 는 ArticleService 에 의존합니다(필요)
	private ArticleService articleservice;
	
	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}
	
	//@GetMapping("")  : spring 5.0부터 지원
	@RequestMapping(method = RequestMethod.GET)  //화면보여주기
	public String form() {
		return "article/newArticleForm";
		
		//viewResolver
		//   /WEB-INF/views/ + article/newArticleForm + .jsp
	}
	
	
	/*
	1. 전통적인 방법으로 Client 데이터 받기 (Spring 에서 사용하지 않아요)

	@RequestMapping(method = RequestMethod.POST) //처리하기
	public ModelAndView submit(HttpServletRequest request) {
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		articleservice.writeArticle(article);
		//처리완료
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", article);
		mv.setViewName("article/newArticleSubmitted");
		return mv;
	}
	
	--------------------------------------------------------------------------------------
	
	2. Spring Parameter DTO 타입으로 받기 
	전제조건 : <input name="값이" >> class 가지는 member field명 같아야 한다.
	
	submit(NewArticleCommand command)
	  1. 자동 DTO 생성 :  NewArticleCommand newArticleCommand = new NewArticleCommand();
	      newArticleCommand의 객체를  command 얘가 받음 
	  2. 넘어온 parameter값을 setter로 자동 주입 
	  3. NewArticleCommand 객체는 IOC 컨테이너 안에 자동으로 생성 id="newArticleCommand"
	
	//이 코드가 없어요. 
	ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", article);
		mv.setViewName("article/newArticleSubmitted");
		return mv; 
		
	mv.addObject("newArticleCommand", article); 이부분이 없어요.. 이게 있어야 key값으로 view단에 뿌리는데?
	이 코드가 자동으로 실행됨 
	자동으로 일어나면 newArticleCommand 이 이름을 뭐로 만드나요?
	- 클래스 이름에서 앞에 글자소문자로 만듦 : NewArticleCommand -> newArticleCommand


    >> forward > view > newArticleCommand
    
    완성본 
   	@RequestMapping(method = RequestMethod.POST) //처리하기
	public String submit(NewArticleCommand command) {   
		articleservice.writeArticle(command);
		//처리완료
		return "article/newArticleSubmitted";
	}
	
	-----------------------------------------------------------------------------------------
	
	3. 객체의 이름(key) 자동생성되는게 싫어요. 내가정의할거예요.   (내가 정의한 이름으로 key를 설정하고 싶을떄)
	@ModelAttribute("Articledata") 얘를 붙이면서 
	new가 일어날때 멤버변수 이름이 바뀜 
	NewArticleCommand Articledata = new NewArticleCommand();
	mv.addObject("Articledata",Articledata);
	*/
	
	//@PostMapping() : spring 5.0부터 지원
	@RequestMapping(method = RequestMethod.POST) //처리하기
	public String submit(@ModelAttribute("Articledata") NewArticleCommand command) {   
		articleservice.writeArticle(command);
		//처리완료
		return "article/newArticleSubmitted";
	}
}
