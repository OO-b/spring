package DI;

//점수를 출력하는 클래스 


public class NewRecordView {
	private NewRecord record;
	public NewRecordView(int kor, int eng, int math) {
		record = new NewRecord(kor, eng, math);
		
	}
	
	public void print() {
		
		System.out.println(record.total() + "/" + record.avg());
	}
}


//NewRecordView얘가 만들어질때 NewRecord얘가 같이 만들어짐. = 복합연관
//NewRecordView는NewRecord한테 의존함 