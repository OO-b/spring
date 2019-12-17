package DI_Annotation_05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {

	public static void main(String[] args) {
		ApplicationContext context =  new AnnotationConfigApplicationContext(ConfigContext.class);
		//메타정보를 주니까 컴파일된걸 줘야함.. 파싱시켜서..?
		User user = context.getBean("user",User.class);  // "user" 함수이름 (xml때는 id값)
		user.userMethod();

		User2 user2 = context.getBean("user2",User2.class);
		user2.userMethod2();
	}

}
