
public class TestCar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		Car c4 = new Car();
		
		c1.name="A";
		c2.name="B";
		c3.name="C";
		c4.name="D";
		
		c1.drive();
		c2.drive();
		c3.drive();
		c4.drive();
		*/
		
		Car c1 = Car.getInstance();
		Car c2 = Car.getInstance();
		c1.name="BMW";
		System.out.println(c2.name);
		
		
		
		

	}

}
