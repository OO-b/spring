package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean , DisposableBean {   
	//InitializingBean초기화 - afterPropertiesSet() 초기화 함수 사용가능
	// DisposableBean 소멸자 - destroy() 소멸자 함수 사용가능 
	public Client() {
		System.out.println("Client Default");
	}
	
	private String defaulthost;
	public Client(String defaulthost){
		this.defaulthost = defaulthost;
		System.out.println("Client Overloading :" + this.defaulthost);
	}
	
	private String host;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client setHost() 호출 : " + this.host);
	}

	public void send(){
		System.out.println("데이터 보내기....");
	}
	
	
	//초기화
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client 초기화 함수 호출");		
	}

	//소멸
	@Override
	public void destroy() throws Exception {
		System.out.println("Client 소멸자 함수 호출");
		
	}

}

/*
  생성자 함수 
 Setter함수 
  초기화함수 호출 됨 (생성자 함수, setter함수 다음으로)
 */
