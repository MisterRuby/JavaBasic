package builder.step2;

import java.util.Objects;

public class NyPizza extends Pizza{

	public enum Size {SMALL, MEDIUM, LARGE};		// 피자 크기
	private final Size size;						// 선택된 피자 크기
	
	public static class Builder extends Pizza.Builder<Builder> {
		
		// 부모 클래스에 포함된 내용. 이 내용들 역시 상속 받았기 때문에 자식 builder를 통해 설정할 수 있다.
//		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
//		
//		public T addTopping(Topping topping) {
//			toppings.add(Objects.requireNonNull(topping));
//			return self();
//		}
		
		private final Size size;
		
		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		public NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
		
	}
	
	private NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}
	
}
