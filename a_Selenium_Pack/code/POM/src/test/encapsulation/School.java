package test.encapsulation;

public class School extends Institution{
	
	Room r=null;
	
	public School(Room r){
		this.r=r;
	}
	
// school IS A institution - Inheritance
// school HAS A room - Encapsulation
}
