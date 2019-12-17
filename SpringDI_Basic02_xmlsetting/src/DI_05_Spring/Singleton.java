package DI_05_Spring;

public class Singleton {
	private Singleton() {}
	private static Singleton instance = new Singleton();
	public static Singleton getInstance() {
		return instance;
	}
}
//하나의 객체를 공유하면서 쓰는 것 
//static을 메모리에 올려놓고  private static Singleton intance = new Singleton)();
// public static Singleton getInstance() {
//return intance;} 는 그걸 돌려쓰는거 
