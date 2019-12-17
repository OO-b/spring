package DI2;

//점수를 출력하는 클래스 

//1. [생성자]를 통해서 필요한 객체를 생성하거나 주입 > DI
//2. 함수([setter]) 를 통해서 필요한 객체를 주입 >> DI2

public class NewRecordView {
	private NewRecord record;
	
	public NewRecordView() {
		super();
	}
	
	public NewRecordView(int kor, int eng, int math) {
		record = new NewRecord(kor, eng, math);
		//함수의 parameter를 통해서 NewRecord 객체의 주소 
	}

	public void setRecord(NewRecord record) {
		this.record = record;
	}

	public void print() {
		System.out.println(record.total() + "/" + record.avg());
	}
}

