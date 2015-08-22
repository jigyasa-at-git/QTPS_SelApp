
public class String_functionality {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// object of string class is made
		String x= "hello how are you. Is is a good day.";
		//String c = new String("ssss sss");
		
		System.out.println(x.charAt(10));
		System.out.println(x.indexOf('a',11));
		System.out.println(x.equals("hello"));
		System.out.println(x.substring(10, 20));// end index -1
		System.out.println(x.indexOf("XXXXXXX"));
		
		
		// split
		System.out.println("**********************");
		String[] arr = x.split("o");
		
		for(int i=0 ; i< arr.length ; i++){
			System.out.println(arr[i]);
		}
		System.out.println("*********CONVERSION************");
		// conversion
		String y="1234";
		int a=Integer.parseInt(y);
		System.out.println(a);
		
		String c=String.valueOf(a);
		System.out.println(c);
		
	}

}
