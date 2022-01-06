package builder.step1;

/**
 * 점증적 생성자 패턴 - 여러 생성자를 쓰는 방법
 */
public class TelescopingNutritionFacts {
	
	// 한 번 생성된 객체 내부의 값은 변하지 않는 불변 객체
	
	private final int servingSize;		// 1회당 제공량
	private final int servings;			// 제공되는 횟수
	private final int calories;			// 1회 제공량 당 칼로리
	private final int fat;				// 1회 제공량당 지방
	private final int carbohydrate;		// 1회 제공량당 탄수화물
	
	
	/**
	 * 매개변수 외의 값들은 0으로 초기화
	 * -> 사용자가 설정하길 원치 않는 매개변수까지 값을 지정해줘야 한다.
	 * -> 매개변수가 많아지면 그만큼 생성자 수가 늘어나고 코드를 작성하거나 읽기 어려워진다.
	 */
	
	public TelescopingNutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}
	
	public TelescopingNutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}
	
	public TelescopingNutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}

	public TelescopingNutritionFacts(int servingSize, int servings, int calories, int fat, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.carbohydrate = carbohydrate;
	}

}
