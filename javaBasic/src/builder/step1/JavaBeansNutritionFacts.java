package builder.step1;

/**
 * 자바 빈즈 패턴 - 일반적인 패턴
 */
public class JavaBeansNutritionFacts {

	private int servingSize;		// 1회당 제공량
	private int servings;			// 제공되는 횟수
	private int calories;			// 1회 제공량 당 칼로리
	private int fat;				// 1회 제공량당 지방
	private int carbohydrate;		// 1회 제공량당 탄수화물
	
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	
	
	
	public int getServingSize() {
		return servingSize;
	}
	public int getServings() {
		return servings;
	}
	public int getCalories() {
		return calories;
	}
	public int getFat() {
		return fat;
	}
	public int getCarbohydrate() {
		return carbohydrate;
	}
	
	public static void main(String[] args) {
		
		// 하나의 객체를 완전히 설정하기 위해 메서드를 여러개 호출해야하고 각 단계마다 일관성이 무너진 상태에 놓이게 된다. 중간 중간에 버그 코드가 개입시 문제가 될 수 있다.
		// 값 설정을 객체 생성 후에 하기 때문에 필드 값은 final로 설정할 수 없다. 즉, 클래스를 불변으로 만들 수 없다.
		JavaBeansNutritionFacts cola = new JavaBeansNutritionFacts();
		cola.setServingSize(240);
		cola.setServings(8);
		cola.setCalories(100);
		cola.setFat(35);
		cola.setCarbohydrate(27);
	}
	
}
