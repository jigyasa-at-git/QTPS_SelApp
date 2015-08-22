package rough;

public class TestHouse {
	public static void main(String[] args) {
		
		
		/*House h1 = new House();
		House h2 = new House();
		h1.city="A";
		h2.city="B";
		*/
		
		House h1 = House.getInstance();
		House h2 = House.getInstance();
		House h3 = House.getInstance();
		
		h1.city="a";
		System.out.println(h1.city);
		System.out.println(h2.city);
		System.out.println(h3.city);
		

		
	}
}
