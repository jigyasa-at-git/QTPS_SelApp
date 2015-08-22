package rough;

public class Client {

	public static void main(String[] args) {
		Bank x = new Bank();
		Bank y = new Bank();
		
		x.name="A";
		y.name="B";
		
		
		Bank b1 =Bank.getInstance();
		b1.name="Citi";
		Bank b2 = Bank.getInstance();
		System.out.println(b2.name);
		Bank.getInstance();
		Bank.getInstance();
		

	}

}
