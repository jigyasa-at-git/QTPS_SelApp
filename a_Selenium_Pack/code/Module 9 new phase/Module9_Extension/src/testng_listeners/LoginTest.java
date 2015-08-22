package testng_listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(priority=1)
	public void login(){
		
		// error = stop
		// error = continue
		System.out.println("start");
		try{
			Assert.assertEquals("A", "X");
		}catch(Throwable t){
			System.out.println("error");
			// code - report error
			ErrorUtil.addVerificationFailure(t);
		}
		
		try{
			Assert.assertEquals("B", "C");
		}catch(Throwable t){
			System.out.println("error");
			// code - report error
			ErrorUtil.addVerificationFailure(t);
		}
		System.out.println("end");
	}
	
	
	@Test(priority=2)
	public void adminLogin(){
		
	}
	
	
	
	

}
