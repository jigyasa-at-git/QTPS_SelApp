package test;

public class SplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String com="1 398.00 € including 19 % tax";
		String [] x =com.split("€");
		System.out.println(x[0]);
	}

}
