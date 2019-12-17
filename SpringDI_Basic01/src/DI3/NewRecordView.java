package DI3;

import java.util.Scanner;

//점수를 출력하는 클래스 


public class NewRecordView implements RecordView{
	private NewRecord record;
	
	//1. [생성자]를 통해서 필요한 객체를 생성하거나 주입 > DI
	//2. 함수([setter]) 를 통해서 필요한 객체를 주입 >> DI2
	//3. 인터페이스 활용 (다형성)
	public NewRecordView() {
		super();
	}

	
	public NewRecordView(int kor, int eng, int math) {
		//함수의 parameter를 통해서 NewRecord 객체의 주소 
		record = new NewRecord(kor, eng, math);
		
	}
	

	public void setRecord(Record record) {  //레코드라는 인터페이스를 구현하는 모든 자식들이 올 수 있음 **(다형성)  - 함수의 파라미터를 Interface로 
		this.record = (NewRecord) record;    //* 다운캐스팅을 해야하는 단점이 있음 
		                                     // 멤버필드를 Record record 로. 타입을 인터페이스로 할 수 잇음 
		                                     // but, 부모타입은 자식타입에 접근이 불가능. 
		                                     // total(), avg() 함수는 부모가 가지고 있지만, setter는 자식만 갖고있어서.. 멤버필드를 부모타입 으로 하면 setter사용 못함
		
	}

	@Override
	public void print() {
		System.out.println(record.total() + "/" + record.avg());
	}


	@Override
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("kor: ");
		record.setKor(scan.nextInt());
		
		System.out.println("eng: ");
		record.setEng(scan.nextInt());
		
		System.out.println("math: ");
		record.setMath(scan.nextInt());
		
	}
}


//NewRecordView얘가 만들어질때 NewRecord얘가 같이 만들어짐. = 복합연관
//NewRecordView는NewRecord한테 의존함 

