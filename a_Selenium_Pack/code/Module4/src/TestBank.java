
public class TestBank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Bank b1 = new HSBCBank();
		b1.credit();
		b1.debit();
		b1.transfermoney();
		
		Object arr[] = new Object[3];
		arr[0]="hello";
		arr[1]=1616;
		arr[2]=true;
		
	}

}
