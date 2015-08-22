
public class Planet {

	String name;
	int moons;
	
	// Constructors
	// there no return type
	// name has to be same as class name
	// default constructor
	public Planet(){
		System.out.println("creating object");
	}
	// overloading
	public Planet(String name,int moons){
		this.name=name;
		this.moons=moons;
	}
	
	public static void main(String[] args) {
		Planet p1 = new Planet();
		p1.name="earth";
		p1.moons=1;
		
		Planet p2 = new Planet();
		p2.name="Jupiter";
		p2.moons=10;
		new Planet();
		new Planet();
		
		Planet p3 = new Planet("mercury",0);
		Planet p4 = new Planet("Pluto",0);
		
		System.out.println(p3.name);

		
		
		
		
	}

}
