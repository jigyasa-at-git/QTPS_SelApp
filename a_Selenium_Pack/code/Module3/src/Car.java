
public class Car {
	
	String name;
	int price;
	Engine eng;
	
	public int inceasePrice(int increment){
		price = price + increment;
		return price;
	}
	
	public Engine getEngine(){
		return eng;
	}
	
	
	

}
