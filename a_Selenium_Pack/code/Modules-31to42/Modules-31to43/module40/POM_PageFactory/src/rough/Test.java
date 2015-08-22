package rough;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Car c1 = new Car();
		Car c2= new Car();
		
		String x="hello";
		System.out.println(c1==c2);
		c1=c2;
		System.out.println(c1==c2);
		
		System.out.println(2==2);
		
		final int i=100;
		//i=102;
	}

}
