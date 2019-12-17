package Spring_DI4;

import java.io.ObjectInputStream.GetField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/* 
		 xml에 작성함으로서 이 3줄이 없어짐 
		 
		NewRecordView view = new NewRecordView();
		NewRecord record = new NewRecord();
		view.setRecord(record);  // 주입. 필요한 객체의 주소를 삽입(주입)
		*/
		//view.input();
		//view.print();
		
		// 이 메인함수에서는 *** SpringFramework 가 제공하는 메모리 생성 (IOC 컨테이너)
		//**Container(메모리공간) 만들고, 그 공간에 필요한 객체를 올려 놓고 주입 작업. 
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml"); // ApplicationContext : 메모리공간을 가질 수 있는 타입 
				                                                                         // ClassPathXmlApplicationContext() 컨테이너를 만드는 클래스 
																						//new ClassPathXmlApplicationContext(주소를 넣는건데, src는 기본값);
		// 컨테이너가 만들어지고 이를 구성하는자원은 xml에 있음 
				//context는 컨테이너의 주소값을 가짐 
				
				RecordView view = (RecordView) context.getBean("view");
				view.input();
				view.print();
				
	   //스프링은 스프링을 사용하는 컨테이너를 만든다  ApplicationContext
	   // 그 공간에 필요한 객체를 올려 놓고 주입 작업한다.  ClassPathXmlApplicationContext("DIConfig.xml");
				
	}

}
