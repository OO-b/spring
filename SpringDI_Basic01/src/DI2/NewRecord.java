package DI2;

//vo, dto, domain 과 같은 개념을 갖는 클래스 (얘네의 공통점 : 데이터를 담을 수 있는 클래스)
public class NewRecord {
	 private int kor;
	 private int eng;
	 private int math;
	 
	 public NewRecord() {}

	public NewRecord(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	
	//필요시  : 별도의 함수 추가 가능 
	public int total() {
		return this.kor + this.eng + this.math;
	}
	
	public float avg() {
		return total()/3.0f;
	}
	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}


	 
	 
}
