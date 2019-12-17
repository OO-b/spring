package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

public class NoticeController implements Controller{

	
	public NoticeController() {
		System.out.println("[NoticeController]");
	}
	
	/*     Spring에서는 코드 상에서 new작업을 하지 X   */
	
	
	//injection하는 방법 : xml(property) / annotation(autowired annotation)
	private NoticeDao noticedao;  //직접 new를 하지않고, xml에서 new해옴. 그래서 주소값이 필요해요. (이를 생성자에서? setter에서? 받을건지결정)
	
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//검색처리
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");  //ex. 타이틀, 컬럼명
		String _query = request.getParameter("p"); //조건값
		
		//default (값이 안들어올 수 잇으니까. default값 처리해주기)
		int page = 1;
		String field = "TITLE";
		String query = "%%";
		
		//조건처리 
		if(_page != null && _page.equals("")) {
			page = Integer.parseInt(_page);
		}
		
		if(_field != null && _field.equals("")) {
			field = _field;
		}
		
		if(_query != null && _query.equals("")) {
			query = _query;
		}
		
		
		//DAO  객체 데이터 받아오기 
		List<Notice> list = noticedao.getNotices(page, field, query);
		
		//Sping  > ModelandView or Model 이라는 객체 제공 
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
	
		return mv;
	}

}
