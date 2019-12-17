package com.service;

import org.springframework.stereotype.Service;

import com.model.NewArticleCommand;

/*
 xml파일 상단 코드에 
 <context:component-scan base-package="com.service" />  를 가지고 있고,
 클래스가 @Service 가지고 있다면 자동으로 bean 생성 
 */
@Service
public class ArticleService {

		public ArticleService() {
			System.out.println("ArticleService 생성자 호출");
		}
		
		
		public void writeArticle(NewArticleCommand command) {
			//DAO 객체 생성
			//DAO 객체가 가지는 insert 함수 호출 (Command) 전달 
			System.out.println("글쓰기 작업완료" + command.toString());
		}
}
