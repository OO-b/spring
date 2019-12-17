package AOP_Basic_02_JAVA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/*
 보조관심(공통관심)구현 
 invoke : 하나의 함수가 여러개의 함수를 대리해서 처리 한다. 
 */

public class LogPrintHandler implements InvocationHandler{
	private Object target; // 실객체의 주소값을 가짐. (주업무는 따로있으니까)
	
	public LogPrintHandler(Object object) {
		System.out.println("LogPrintHandler : 보조관심 생성자 호출");
		this.target = object;
	}
	
	//주업무(함수) - ADD, MUL, SUB 3개의 함수
	// 주업무의 함수를 누군가가 대리해서 처리 -> invoke  (주업무의 어떤 함수가 불러져도 invoke함수가 불러짐)
	//즉, invoke함수가 보조업무를 처리함 

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
	System.out.println("Invoke 함수가 호출");
	System.out.println("method : 호출된 함수명  :" + method);
	System.out.println("method의 parameter값을 따로받음 :" + Arrays.toString(args));
	
		//보조공통업무(advice)
		Log log = LogFactory.getLog(this.getClass());  
		
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작되었습니다.]");
		
		
		//주업무  ( -> 실객체가 가지는 함수 호출 ! ) * 
		int result = (int)method.invoke(this.target, args);      //method안에도 invoke 함수를 가짐
		
		
		//보조공통업무(advice)
		sw.stop();
		log.info("[타이머가 종료되었습니다.]");
		log.info("[TIME LOG Method]" + method);
		log.info("[TIME LOG Method Time : " + sw.getTotalTimeMillis()+"]");
		
		return result;
	}  

}
