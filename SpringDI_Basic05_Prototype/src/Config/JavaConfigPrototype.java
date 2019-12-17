package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import Spring.Client;

//xml > java 파일 > prototype 설정

@Configuration   //환경설정파일임을 명시
public class JavaConfigPrototype {
/*	
  <bean id="client" class="Spring.Client" scope="prototype">
	<property name="host" value="webserver"></property>
	</bean>
*/
	@Bean
	@Scope("prototype")  //getBean 할때마다 새 객체 생성   <scope="prototype"> 같은 역할 
	
	public Client client(){  //이 안에서 객체를 만들고, setter까지 주입하기 위해서 
		Client client = new Client();
		client.setHost("webserver");
		return client;
		
		//짧게 쓰고싶으면, 밑에처럼 써도 되지만 return 타입이 다름 
		//return new Client().setHost("webserver");
	}
	

}