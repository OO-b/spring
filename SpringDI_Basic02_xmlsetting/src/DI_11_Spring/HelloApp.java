package DI_11_Spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class HelloApp {
	public static void main(String[] args) {
	

		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_11_Spring/DI_11.xml"); 
		DataSourceFactory factory = context.getBean("dataSourceFactory", DataSourceFactory.class);
	
		System.out.println(factory.toString());
		
	}
	
	
}


