package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import Spring.Client;
import Config.JavaConfigPrototype;

public class MainPrototypeConfig {

	public static void main(String[] args) {
		ApplicationContext context =  new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		Client client =  context.getBean("client", Client.class);
		Client client2 = context.getBean("client", Client.class);
		System.out.println("client : " + client.toString());
		System.out.println("client2 : " + client2.toString());
	}

}


/*
 JavaConfigPrototype.java에서 
 @Scope("prototype") 를 지우면 client, client2 같은 값을 내고 
 @Scope("prototype") 는 getBean할때마다 새로운 객체를 생성해주겠다는 이야기 이기 때문에 
 명시해주면, 다른 값을 낸다. 

 */
 