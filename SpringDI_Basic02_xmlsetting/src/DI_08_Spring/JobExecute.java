package DI_08_Spring;

public class JobExecute {
	
	public JobExecute(String first, int second) {
		System.out.println("String, int 파라미터로 받는 함수 ");
	}
	
	public JobExecute(String first, long second) {
		System.out.println("String, long 파라미터로 받는 함수 ");
	}
	
	public JobExecute(String first, String second) {
		System.out.println("String, String 파라미터로 받는 함수 ");
	}
	
	private ArticleDao articledao;

	public ArticleDao getArticledao() {
		return articledao;
	}

	public void setArticledao(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("SetterArticleDao 주입 확인 : " + this.articledao);
	}
	
	
	private int data;
	
	public void setData(int data) {
		this.data = data;
		System.out.println("setData value :" + this.data);
	}
	
	
}


