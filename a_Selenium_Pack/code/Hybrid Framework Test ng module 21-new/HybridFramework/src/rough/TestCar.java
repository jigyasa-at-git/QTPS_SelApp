package rough;

public class TestCar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// force not create objects directly
		//Car c1 = new Car();
		//Car c2 = new Car();
		
		Car c1 = Car.getCarInstance();
		c1.name="Audi";
		Car c2 = Car.getCarInstance();
		Car c3 = Car.getCarInstance();
		Car c4 = Car.getCarInstance();
		
		
		System.out.println(c1.name);
		System.out.println(c2.name);
		System.out.println(c3.name);
		System.out.println(c4.name);
	}

}
