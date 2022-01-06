package builder.step1;
/**
 * 빌더 패턴 - 필드 내부의 값이 초기값을 유지하는 불변 객체를 만드는데 있어서 일관성을 유지할 수 있어 용이하다.
 * 	- 빌더 패턴은 builder 작성 때문에 코드가 장황하기 때문에 매개변수가 적은 경우에는 오히려 비효율적일 수 있다.
 *  - 매개 변수가 많으며 다수가 필수가 아니거나 필드의 다수가 같은 타입일 때 특히 유용하다.
 */
public class BuilderNutritionFacts {
	
	// 한 번 생성된 객체 내부의 값은 변하지 않는 불변 객체.

	private final int servingSize;		// 1회당 제공량
	private final int servings;			// 제공되는 횟수
	private final int calories;			// 1회 제공량 당 칼로리
	private final int fat;				// 1회 제공량당 지방
	private final int carbohydrate;		// 1회 제공량당 탄수화물
	
	public static class Builder {
		
		// 필수로 초기에 설정해줘야 하는 매개변수
		private final int servingSize;		// 1회당 제공량
		private final int servings;			// 제공되는 횟수
		
		// 선택 매개변수 - 꼭 설정할 필요없이 상황에 따라 원하는 변수만 설정
		private int calories 		= 0;			// 1회 제공량 당 칼로리
		private int fat				= 0;				// 1회 제공량당 지방
		private int carbohydrate	= 0;		// 1회 제공량당 탄수화물
		
		// Builder 생성자를 통해 필수 매개변수를 받는다.
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int calories) {
			this.calories = calories;
			return this;
		}
		
		public Builder fat(int fat) {
			this.fat = fat;
			return this;
		}
		
		public Builder carbohydrate(int carbohydrate) {
			this.carbohydrate = carbohydrate;
			return this;
		}
		
		public BuilderNutritionFacts build() {
			return new BuilderNutritionFacts(this);
		}
		
	}

	
	/**
	 * 내부의 빌더 클래스에 설정된 값들로 필드 변수들을 초기화
	 */
	public BuilderNutritionFacts(Builder builder) {
		this.servingSize 	= builder.servingSize;
		this.servings 		= builder.servings;
		this.calories 		= builder.calories;
		this.fat 			= builder.fat;
		this.carbohydrate 	= builder.carbohydrate;
	}
	
	public static void main(String[] args) {
		BuilderNutritionFacts cola = new Builder(240, 8)		// static class Builder의 해당 매개변수들에 맞는 필드값 설정
									.calories(100)									// Builder.calories(). builder 객체의 calories 값 설정. 반환 값은 builder 객체
									.carbohydrate(27)								// Builder.carbohydrate(). builder 객체의 carbohydrate 값 설정. 반환 값은 builder 객체
									.build();										// Builder.build(). Builder에 최종 설정된 값들을 통해 한번에 객체의 필드값이 설정 된 새 BuilderNutritionFacts 객체 반환
		
		System.out.println(cola.getClass());
	}
	
}
