package AOP_Basic_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/* 
 요구사항 
 : 간단한 계산기 프로그램 만들기 
 
    .. 주업무를 하는 사람이 보조업무를 몰라야함 (AOP) 
  - 주관심(Core Concern) 업무 : 사칙연산 -> 기능 (함수)
  - 보조관심/공통사항(Cross Cutting Concern) : 연산에 걸린 시간   
  - log 출력(Console로 출력하는데 시스템이 출력하는 것처럼 red 색으로 시간을 나타내세요.)
   
 */


public class Calc {
	
	public int Add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());  //this.getClass() : 현재동작하고 있는 객체
		//System.currentTimeMillis();  - 자바에서 제공하는 시간 출력 함수
		
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작되었습니다.]");
		
		int result = x + y;   //주관심
		
		sw.stop();
		log.info("[타이머가 종료되었습니다.]");
		log.info("[TIME LOG Method : Add 함수]");
		log.info("[TIME LOG Method Time : " + sw.getTotalTimeMillis()+"]");

		return result;
	}
	
	
	public int Mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());  //this.getClass() : 현재동작하고 있는 객체
		
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작되었습니다.]");
		
		int result = x * y;  //주관심 
		
		sw.stop();
		log.info("[타이머가 종료되었습니다.]");
		log.info("[TIME LOG Method : Mul 함수]");
		log.info("[TIME LOG Method Time : " + sw.getTotalTimeMillis()+"]");
		return result;
	}
}

//LogFactory : spring에서 제공하는 시간출력 함수. 
//console창에 찍을 수도 있고, 파일로 저장 할 수 도 있음 
//System.currentTimeMillis();  - 자바에서 제공하는 시간 출력 함수

