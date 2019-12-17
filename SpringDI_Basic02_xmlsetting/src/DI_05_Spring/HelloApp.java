package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class HelloApp {
	public static void main(String[] args) {
		
		/*   
		 * 이부분을 xml에서 처리 함 
		 
		 
		MyBean mybean = new MyBean();
		MyBean mybean2 = new MyBean("hong");
	
		Singleton single = Singleton.getInstance();   //new X / static에 있는거 갖다 씀
		Singleton single2 = Singleton.getInstance(); 		
		
		
		
		//우리가 검증하고 싶은건 주소값 ! 
		//mybean, mybean2는 주소값이 다름. new할때마다 새로운 주소값가지니까 
		//but, singleton은 100개를 만들어도 주소가 같아야함 
		
		System.out.println("mybean : " + mybean);   //DI_05_Spring.MyBean@15db9742
		System.out.println("mybean2 : " + mybean2); //DI_05_Spring.MyBean@6d06d69c
		System.out.println("single : " + single);   //DI_05_Spring.Singleton@7852e922
		System.out.println("single : " + single2);  //DI_05_Spring.Singleton@7852e922
		 */
		

		
		 ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml"); 
		 /* 
		         위에 한줄의 의미 
		     :  스프링 컨테이너가 구성되고, xml 파일을 read해서 파싱(xml파일을 파싱하고 해석해서 그 안에 객체를 생성하고, 그안에서 조립(injection) )
		     
		     >> 컨테이너 안에 객체가 생성되어 있음. 필요한 객체 사용
		     
		     generic쓰면 타입을 미리 정할 수 있음 
		     
		     
		     getbean : 컨테이너안에있는걸 가져오는 함수 / 객체를 만드는건 아니예요!!!!!!! 
		       그래서 mybean mybean2 mybean3 끼리는 같고 
		     mybean4는 다른것 
		     
		  */
		 
		 
		 
		 //default는 싱글톤 
		 //결국 스프링은 모든 객체의 타입을 싱글톤으로 봄 
		 //스프링은 굳이 싱글톤으로 설계할 필요가 없음. 
		 //getbean할때마다 뉴를 하는게 아니기 때문에 (getbean은 가져오는것 !!! ***************)
		 
		 MyBean mybean = context.getBean("mybean", MyBean.class);   //DI_05_Spring.MyBean@5700d6b1
		 MyBean mybean2 = context.getBean("mybean", MyBean.class);  //DI_05_Spring.MyBean@5700d6b1
		 MyBean mybean3 = context.getBean("mybean", MyBean.class);  //DI_05_Spring.MyBean@5700d6b1
		 System.out.println(mybean + "," + mybean2 + "," + mybean3);

		 MyBean mybean4 = context.getBean("mybean2", MyBean.class);  //DI_05_Spring.MyBean@6fd02e5
		 System.out.println(mybean4);
		 
		 
		 Singleton single = context.getBean("single", Singleton.class);  //DI_05_Spring.Singleton@5bcab519
		 Singleton single2 = context.getBean("single", Singleton.class); //DI_05_Spring.Singleton@5bcab519
		 System.out.println(single + "," + single2 );



	}
	
	
}

/*
   getBean() : 컨테이너 안에 있는 Object 타입의 객체를 return 해줌   > 이를 사용자가 필요에따라 down casting해서 사용 
      주의 ★★   : getBean()은 호출시에 새로운 객체를 만들지 않습니다.  
      스프링 컨테이너가 가지는 객체의 타입은 : default Singleton
      그래서 굳이 singleton을 만들 필요가 없어요. 
   
      예외적으로 getBean 함수가 객체를 생성하게 할 수 있다. (거의 쓰지 않음)
 */
