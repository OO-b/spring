package com.aopEx;

import org.aspectj.lang.ProceedingJoinPoint;


public class LogAop {
		
	public Object loggerAop(ProceedingJoinPoint joinpoint) {
		
		//공통 기능이 적용되는 메서드가 어떤 메서드인지 출력하기 위해 메서드명을 얻어옴

		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "시작");  //메서드 실행
		
		//공통기능 
		System.out.println("핵심기능 전 실행할 공통기능 " + System.currentTimeMillis());
		
		Object obj = null;
		try {
			obj = joinpoint.proceed();   //핵심기능

		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("핵심기능 후 실행할 공통사항 " + System.currentTimeMillis());
		
		System.out.println(signatureStr + "종료");
		return obj;
		
	}
}
