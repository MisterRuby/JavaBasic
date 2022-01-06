package builder.step2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

	public enum Topping {MUSHROOM, ONION, PEPPER}						// Topping 메뉴. enum을 외부가 아닌 내부에 해당 방식으로 선언해서 사용할 수도 있다. 해당 클래스에서만 사용할 시 유용한 방식
	
	final Set<Topping> toppings;										// 선택한 Topping 메뉴를 저장한 Collection
	
	abstract static class Builder<T extends Builder<T>> {
		// Builder<T extends Builder<T>> =>  이 클래스를 상속받는 서브클래스는 Sub extends Super<Sub> 형태로 상속 받는다.
		
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			// requireNonNull() : 인자의 null 체크를 해주고 null이 아닐 시 인자 값을 그대로 반환. 인자가 null 일 경우 NullPointerException 을 발생시킨다.
			
			return self();
		}
		
		abstract Pizza build();
		
		/**
		 * 하위 클래스는 이 메서드를 재정의하여 반드시 this를 반환하도록 해야한다.
		 */
		protected abstract T self();
	}
	
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
		// builder에 설정된 toppings 를 복제하여 설정(깊은 복사).
		// 얇은 복사로 값을 설정해버리면 Pizza 객체의 모든 topping가 같은 주소의 값을 공유하게 됨으로 주의한다.
	}
	
}
