package rough;

public class Bank {
	static Bank b;
	
	String name;
	
	
	public static Bank getInstance(){
		
		if(b==null){
			b=new Bank();
		}
		
		return b;
	}

}
