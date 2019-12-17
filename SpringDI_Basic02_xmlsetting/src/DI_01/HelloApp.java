package DI_01;

public class HelloApp {
	public static void main(String[] args) {
		
		MessageBean messagebean = new MessageBean();
		messagebean.sayHello("Bae");
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
