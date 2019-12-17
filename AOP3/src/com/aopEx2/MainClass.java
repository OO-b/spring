package com.aopEx2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Cats myCat = ctx.getBean("myCat", Cats.class);
		Dogs mydog = ctx.getBean("myDog", Dogs.class);

		myCat.getCatsInfo();
		//mydog.getDogInfo();	
	}

}
