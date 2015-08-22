package rough;

public class Car {
	
	String name;
	static Car c= null;
	
	
	private Car(){
		System.out.println("in constructor");
		
	}
	
	
	public void printName(){
		
	}
	// returns you single object of car class
	public static Car getCarInstance(){
		if(c==null){
			c= new Car();
		}
		
		return c;
		
	}
	
	
	

}
