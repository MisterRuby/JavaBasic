package enumEx;

/**
 * enum 내부의 값은 toString() 메서드를 오버라이딩 함으로서 출력되는 값을 바꿀 수 있다.
 * 	-> override 하지 않으면 enum 값 그대로 출력된다.
 * 코드에 해당되는 값들을 아래처럼 정리해서 활용하면 유용하다.
 */
public enum SampleInsPrice {

	PLUTE("1000000"),
	
	VIOLIN("2000000"),
	
	VIOLA("1500000"),
	
	PIANO("3000000");
	
	private final String price;

	SampleInsPrice(String price) {
		this.price = price;
	}
	
	/**
	 * toString() 메서드를 재정의하여 열거형 원소의 ()안의 값이 출력되도록 변경
	 */
	@Override
	public String toString() {
		return price;
	}
	
}
