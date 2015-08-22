
public class Arrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = new int[5];
		arr[0]=78;
		arr[1]=980;
		arr[2]=98;
		arr[3]=9;
		arr[4]=765;
		
		System.out.println(arr[2]);
		System.out.println("Length of array is --" + arr.length);
		for(int i = 0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		
		String str[] = new String[3];
		str[0]="USA";
		str[1]="india";
		str[2]="uk";
		//str[3]="uytr";
		
		System.out.println("*************TWO DIM ARRAYS****************");
			 				   //[ROW][COL]
		String s[][] = new String[2][4];
		// 1st row
		s[0][0]="hello";
		s[0][1]="world";
		s[0][2]="java";
		s[0][3]="qtp";
		
		// 2nd row
		s[1][0]="usa";
		s[1][1]="uk";
		s[1][2]="India";
		s[1][3]="Australia";
		
		System.out.println("Rows are --- "+s.length);
		System.out.println("cols are --  "+s[0].length);
		
		System.out.println(s[0][1]);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
