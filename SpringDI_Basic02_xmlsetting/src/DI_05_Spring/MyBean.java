package DI_05_Spring;
//빈객체가 어느시점에 만들어질까? 타입은 뭘까? 알아보기 위함 

public class MyBean {
	public MyBean() {
		System.out.println("Default");
	}
	
	public MyBean(String name) {
		System.out.println("Overloading : " + name);
	}
	
}
