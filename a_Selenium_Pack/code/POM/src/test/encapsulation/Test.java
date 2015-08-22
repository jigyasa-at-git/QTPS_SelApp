package test.encapsulation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Room r= new Room();
		r.setSpace(1000);
		School s = new School(r);
		s.teach();
		System.out.println(s.r.getSpace());
	}

}
