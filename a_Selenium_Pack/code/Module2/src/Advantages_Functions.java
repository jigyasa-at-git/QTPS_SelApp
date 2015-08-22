
public class Advantages_Functions {
	
	public static void main(String[] args) {
	
		int res= calculateFacorial(15);
		System.out.println("Factorial is "+ res);
	
	}
	
	
	public static int calculateFacorial(int n){
		// 5 - 5*4*3*2*1
		int result=1;
		for(int i =1; i<=n ; i++){
			result=result * i;
			/*
			 	i      result
			  	1        1
			  	2        2
			  	3	     6
			  	4		24
			  	5		120
			  
			  
			 */
			
		}
		return result;
	}
	
	public static boolean login(String username, String password){
		// selenium code to login - open browser and login
		return true; // login is success
		// return false;
	}
	
	
	
	
	

}
