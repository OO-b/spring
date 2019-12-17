package com.aopEx2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // Aspect 역할을 할 클래스라고 명시해 줌 
public class LogAop {
		
	//Pointcut이라고 명시된 메서드가 필요
    //@Pointcut의 속성에 핵심코드의 어느 부분까지 공통기능을 사용하겠다고 명시
	@Pointcut("within(com.aopEx2.Cats)")  
	private void pointcutMethod() {
		
	}
	@Pointcut("within(com.aopEx2.Dogs)")  
	private void pointcutMethod2() {
		
	}
	
	@Around("pointcutMethod()") //around가 적용될 포인트컷을 명시 : pointcutMethod()
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		//공통 기능이 적용되는 메서드가 어떤 메서드인지 출력하기 위해 메서드명을 얻어옴
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "시작");  //메서드 실행
		
		//공통기능 
		System.out.println("핵심기능 전 실행할 공통기능 " + System.currentTimeMillis());
		
	
		try {
			Object obj = joinpoint.proceed();   //핵심기능
			return obj;
		}finally {
			System.out.println("핵심기능 후 실행할 공통사항 " + System.currentTimeMillis());
			
			System.out.println(signatureStr + "종료");
		} 
	}
	
	@Before("pointcutMethod()")
	public void beforeMethod() {
		System.out.println("다정이짱");
	}
}
