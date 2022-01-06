package builder.step2;

public class PizzaMain {

	public static void main(String[] args) {
		NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
						.addTopping(Pizza.Topping.MUSHROOM)
						.addTopping(Pizza.Topping.ONION).build();
		
		CalzonePizza calzonePizza = new CalzonePizza.Builder()
									.addTopping(Pizza.Topping.MUSHROOM)
									.sauceInside()
									.build();

	}

}
