package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class HelloApp {
	public static void main(String[] args) {
		//영문 
		//MessageBean_en messagebean_en = new MessageBean_en();
		//messagebean_en.sayHello("Bae");
		
		//한글
		//MessageBean_en messagebean_kr = new MessageBean_en();
		//messagebean_kr.sayHello("Bae");

		//interface 하나의 참조 변수가 여러개의 주소를 가질 수 있다. (다형성)
		
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml"); 

		MessageBean messagebean = context.getBean("message", MessageBean.class);
		messagebean.sayHello("hong");

		 
	}
	
	
}

/* 요구사항
 영문버전 (hong) : Hello hong!
 한글버전 (hong) : 안녕 hong!
 
 기능이 2가지
 
 MessageBean_kr > 함수 > sayHello 
 MessageBean_en > 함수 > sayHello
 
 > 인터페이스 MessageBean를 설계해서 > kr도 en도 구현하게 해볼게요.
 */
