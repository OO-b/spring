package DI_06_Spring;

public class ArticleService {
	// 서비스 단 
	// 사용자의 요청에 따라서 글쓰기 작업, 목록보기, 수정하기 가능해야함 
	// 서비스를 하기 위해서는 DB작업을 해야해요. > DAO단 
	
	// DAO라는 객체를 만드는 작업
	// "Article 서비스는 디에이오가 필요합니다."  (의존성 주입 DI)
	//  스프링에서는 필요할때 가져오는 방법 2가지 - 생성자로 주입 / setter로 주입 
	
	private ArticleDao articledao;    //멤버필드를 하나 만들어서. 이 변수가 실객체의 주소를 가지게 함  ★  (이 방법이 2가지)
	
	public ArticleService(ArticleDao articledao) { //생성자 주입으로 선택
		this.articledao = articledao; //주소값 할당 
		System.out.println("ArticleService 생성자 함수 호출 ");
	}
	
	//글쓰기 서비스
	public void write(Article article) {  // dependency (멤버필드 존재 X)  
		this.articledao.insert(article); 
	}
}
