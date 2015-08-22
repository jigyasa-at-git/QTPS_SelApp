package rough;

// singleton - only one object
public class House {
	
	public static House obj;
	String city;

	
	private House(){
		//System.out.println("tt");
	}
	
	// return you House Object reference
	public static House getInstance(){
		
		if(obj==null){
			obj=new House();
			return obj;
		}else{
			return obj;
		}
			
		
	}
}
