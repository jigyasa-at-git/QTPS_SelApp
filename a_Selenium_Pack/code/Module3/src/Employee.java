
public class Employee {
	// GLOBAL VARIABLES
	public String name;  // ns
	public int salary;	// ns
	public static String companyName; //global static 
	
	//ns - part of object
	// static - not a part of object.
	   //Property of class and common for all objects
	
	// ns
	public void doInduction(){
		System.out.println("Emplyee induction complete " +name);
	}
	
	// ns
	public void removeEmployee(){
		System.out.println("Employee removed from company "+name);
	}
	
	// ns
	public void promote(){
		System.out.println("Employee promoted "+name);
	}
	
	// static function
	public static void giveSalaryOnMonthend(){
		System.out.println("All employees given salary");
	}

}





