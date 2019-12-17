package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class HelloApp {
	public static void main(String[] args) {
		
		//insert작업 (mysql로 작업하세요.)
		//MySqlArticleDao articledao = new MySqlArticleDao();
		//(오라클로 작업하세요.)
		
		/* 이걸 다 xml에서 처리 
		OracleArticleDao articledao = new OracleArticleDao();
		ArticleService articleservice = new ArticleService(articledao);
		
		Article article = new Article();
		articleservice.write(article);
		*/
		
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml"); 
		Article article = context.getBean("article", Article.class);
		ArticleService articleservice = context.getBean("articleservice", ArticleService.class);
		
		articleservice.write(article);

	}
	
	
}


