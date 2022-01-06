package StaticFactoryMethod;

public class SFMMain {

	public static void main(String[] args) {
		// 정적 팩토리 메서드를 통해 객체를 생성시 좀 더 명확한 의도가 담긴 메서드로 생성할 수 있다.
		Instrument plute = Instrument.plute();
		Instrument violin = Instrument.violin();

		System.out.println(plute.getValue());
		System.out.println(violin.getValue());


		// null 출력. 정적 팩토리 메소드의 내부 코드를 통해 같은 유형의 객체 생성을 제한
		System.out.println(Instrument.plute());			// 위에서 이미 plute 유형의 Instrument 객체를 생성했으므로 객체생성을 하지 않고 null을 반환
		System.out.println(Instrument.violin());

	}
}
