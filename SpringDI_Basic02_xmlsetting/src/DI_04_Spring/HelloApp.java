package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class HelloApp {
	public static void main(String[] args) {
		
		//xml에서 처리했기때문에 필요없음 이제.
		
	//MessageBeanImpl messagebean = new MessageBeanImpl("hong");
	//messagebean.setGreeting("hello");
	//messagebean.sayHello();

	
		
		 ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml"); //
		 MessageBean messagebean = context.getBean("m1", MessageBean.class);
			messagebean.sayHello();
		  //ApplicationContext : 메모리공간을 가질 수 있는 타입
		 //GenericXmlApplicationContext("classpath: 패키지명/xml파일이름)
		  
		  //MessageBean이라는 타입을 지정 MessageBean messagebean = context.getBean("message", MessageBean.class); messagebean.sayHello("hong");
		 

	}
	
	
}
