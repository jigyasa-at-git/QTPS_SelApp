
public class Operators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String x="hello howzz u";
		
		int a=1000;
		int b=200;
		int c=300;
		//+ -- concatination operator
		System.out.println("value of a is " + a);
		System.out.println(a+b);
		System.out.println("sum of a and b is "+ a + b);
		System.out.println("sum of a and b is "+ (a + b));
		System.out.println(a+b+" is the sum of a and b");

		
		// || &&
		// >  <  >= <= == !=
		if(a>b && a>c){
			System.out.println("a is the greatest "+a);
		}else if(b>c){
			System.out.println("b is greatest "+b);
		}else{
			System.out.println("c is greatest "+ c);
		}
		
		
		if(b!=c){
			System.out.println("b is not equal to c");
		}
		
		
		String p="selenium class";
		String o="selenium class";
		// never compare string s like this
		if(p==o){
			
		}
		
		if(p.equals(o)){
			System.out.println("p and o are equal");
		}else{
			System.out.println("p and o are unequal");
		}
		
		
		
	}

}
