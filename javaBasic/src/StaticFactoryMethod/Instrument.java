package StaticFactoryMethod;

public class Instrument {
	
	private int value;
	
	private static boolean pluteStatus = false;
	private static boolean violinStatus = false;
	
	/**
	 * 새로운 객체를 반환하는 정적 팩토리 메소드.
	 * 	- static 메소드를 통해 새 메소드를 반환받는다.
	 * 	- 매개변수와 생성자 자체만으로는 반환될 객체의 특성을 제대로 설명하지 못하는 반면에 정적 팩토리 메소드는 이름을 통해 반환될 객체의 특성을 쉽게 묘사할 수 있다.
	 * 	- 내부 코드의 작성을 통해 호출시 인스턴스 생성을 조절할 수 있다.
	 */
	public static Instrument plute() {
		if(!pluteStatus) {
			Instrument plute = new Instrument();
			plute.value = 1000000;
			
			pluteStatus = !pluteStatus;
			
			return plute;
		}
		
		return null;
	}
	
	public static Instrument violin() {
		if(!violinStatus) {
			Instrument violin = new Instrument();
			violin.value = 1000000;
			
			violinStatus = !violinStatus;
			
			return violin;
		}
		
		return null;
	}

	public int getValue() {
		return value;
	}

	public Instrument setValue(int value) {
		this.value = value;
		return this;
	}
	
	
}
