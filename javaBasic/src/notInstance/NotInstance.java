package notInstance;

/**
 * 클래스의 인스턴스화를 막고 싶다면 생성자를 private으로 설정한다.
 *  -> 생성자가 private 이기 때문에 상속을 불가능하게 만드는 효과도 있다. 서브클래스가 접근할 수 없기 때문
 */
public class NotInstance {

	private NotInstance() {}		// 생성자를  private 으로 설정함으로서 외부에서 인스턴스(객체)를 생성할 수 없다.
	
}
