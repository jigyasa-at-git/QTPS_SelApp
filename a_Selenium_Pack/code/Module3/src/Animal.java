
public class Animal {
	
	public String name; // ns
	public int avgAge;  // ns
	public static int eyes; // static
	
	
	public static void eat(){
		
	}
	
	public void fly(){
		
	}
	
	public static void main(String arg[]){
		Animal a1= new Animal();
		a1.name="dog";
		a1.avgAge=10;
		
		Animal a2= new Animal();
		a2.name="elephant";
		a2.avgAge=200;
		
		Animal a3=new Animal();
		a3.name="sparrow";
		a3.avgAge=5;
		
		Animal.eyes=2;
		eyes=2;
		eat();
		a1.fly();
		//name="sparrow";
		
		// static functions call only access static varibales
		//and functions
		
		System.out.println("**********OBJECT REFERENCES************");
		
		//Animal a4=null; // a4 is reference to animal class object
		Animal a4 = new Animal();
		//Animal a5=null;
		//a5.name="xxxxx";
		
		// a1->dog
		// a2->elepahnt
		//a3-> sparrow
		
		a1=a3;
		System.out.println(a1.name);
		System.out.println(a3.name);
		
		a1.name="humming bird";
		System.out.println(a1.name);
		System.out.println(a3.name);
		
		a3=a2;
		System.out.println(a2.name);
		System.out.println(a3.name);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	}
	

}
