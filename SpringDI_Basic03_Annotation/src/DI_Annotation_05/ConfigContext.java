package DI_Annotation_05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 ConfigContext 자바파일로 xml 설정 파일을 대체하겠다
 ConfigContext 자바 가지고 객체의 생성과 조립(주입)
 
 @Configuration (설정파일)
 @Bean (객체 생성) 함수 기반
 
 xml 문서라면
 <bean id="user" class="DI_Annotation_05.User">
 <bean id="user2" class="DI_Annotation_05.User2">
 
 위 코드를 자바파일에서는 함수로 만들어서 객체를 리턴
  
*/


@Configuration                                                 //  @Configuration   :  컴파일러가 스프링 컨테이너를 구성할 수 있는 환경설정 파일(like xml)로 인지함 
public class ConfigContext {
	
	// 밖에서 받을 수 있어야하기때문에 public
	// <bean id="user" class="DI_Annotation_05.User">
	// @Bean : 너는 bean을 만드는 녀석이야. 
	@Bean
	public User user() {
		return new User();
	}
	
	// <bean id="user2" class="DI_Annotation_05.User2">
	@Bean
	public User2 user2() {
		return new User2();
	}

}


