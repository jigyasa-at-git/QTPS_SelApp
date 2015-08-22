
public class Car {
	

	static Car c= null;
	String name;
	
	private Car(){
		
	}
	
	public void drive(){
		System.out.println("Driving "+ name);
	}
	
	public static Car getInstance(){
		
		if(c==null)
			c= new Car();
		
		
		return c;
		
	}
}
