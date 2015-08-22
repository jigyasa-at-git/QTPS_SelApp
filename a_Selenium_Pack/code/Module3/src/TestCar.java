
public class TestCar {
	
	public static void main(String arg[]){

		Car c1 = new Car();
		c1.name="BMW";
		c1.price=99999999;
		
		c1.inceasePrice(100);
		System.out.println(c1.price);
		
		Engine e = new Engine();
		e.mdNumber="AE9282";
		e.milage=20;
		
		c1.eng=e;
		
		System.out.println(c1.eng.mdNumber);
		System.out.println(c1.eng.milage);
		
		
		Car c2 =  new Car();
		c2.name="merc";
		c2.price=9299292;
		c2.eng = new Engine();
		
		c2.eng.mdNumber="C Class engine";
		c2.eng.milage=10;
		
		Engine en = c2.getEngine();
		en.start();
		en.stop();
		
		
		c2.getEngine().start();
		c2.getEngine().stop();
		
		
		
		
		
		
		
		
		
		
		
	}

}
