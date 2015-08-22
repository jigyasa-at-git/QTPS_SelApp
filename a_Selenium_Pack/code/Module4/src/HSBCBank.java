
public class HSBCBank implements Bank{

	@Override
	public void transfermoney() {
		System.out.println("HSBC transfering money");		
	}

	@Override
	public void debit() {
		System.out.println("HSBC debeting money");		
		
	}

	@Override
	public void credit() {
		System.out.println("HSBC crediting money");		
		
	}
	
	public void openaccount(){
		System.out.println("opening act");
	}

}
