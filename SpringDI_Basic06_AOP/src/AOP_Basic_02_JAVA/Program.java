package AOP_Basic_02_JAVA;

import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		Calc calc = new NewCalc();   
		// calc.ADD(x, y)  - 이건 실객체로 바로 접근하는 것. 보조업무 타지 X
		
		//Proxy 객체 통해서 처리 (proxy : java.lang.reflect.Proxy 밑에 있음)
		//Proxy 객체를 만드는 Code
		Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(),  // 1 : 실 객체의 메타정보, + 메모리에 올리는 것까지 (getClassLoader)
				               calc.getClass().getInterfaces(),   // 2 : 행위정보  (그 함수는 interface가 가지고있음)
				               new LogPrintHandler(calc));        // 3: 보조객체 >> parameter로 실객체 주소
		
		//proxy를 통해서 처리하지만, 
		//사용하는 실제 사용자는 실제 Calc 객체를사용하는 것 처럼 사용
		//ADD는 실객체꺼가 아님! 속이는 것! 
		int result = cal.ADD(50000, 123456);
		System.out.println("Main result " + result);
		
		result = cal.MUL(10000, 100000);
		System.out.println("Main2 result " + result);
		

	}

}
