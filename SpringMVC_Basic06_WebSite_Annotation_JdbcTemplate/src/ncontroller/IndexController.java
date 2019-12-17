package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {  // xml에서  component Scan 했으니까, xml에서 bean 객체 만들 필요 X 
	
	@RequestMapping("/index.htm")
	public String index() {
		return "index.jsp";
	}

}
