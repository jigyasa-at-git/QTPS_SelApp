
public class PostandPreIncrementOperators {

	public static void main(String[] args) {

		
		int i =1;
		i++;// i i+i
		// use value of i and then increment it
		System.out.println(i++);
		System.out.println(i); // 3
		
		int x=2;
		int y=x++;
		
		System.out.println("y is "+ y);
		System.out.println("x is "+ x);
		
		// preincrement
		// first value is incremented and then used
		int z=9;
		System.out.println(++z);
		int u=8;
		int p=++u;
		System.out.println(" p is "+p);
		System.out.println(" u is "+u);
		
		//x++ x--  post increment op
		//++x --x  preincrement operators
		
	}

}
