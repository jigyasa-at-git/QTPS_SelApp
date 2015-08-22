package tests;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class LoginTest {
	
	@Rule
	public ErrorCollector errCol = new ErrorCollector();
	
	
	@Test
	public void testApp(){
		// selenium code login
		System.out.println("A");
		try{
			Assert.assertEquals("Hello", "Hello123");
		}catch(Throwable t){
			// code to report error
			errCol.addError(t);
			System.out.println("error");
		}
		System.out.println("B");
		try{
			Assert.assertTrue("Link not present", false);
		}catch(Throwable t){
			errCol.addError(t);
		}
		
		System.out.println("Ending test");

		
		
		
	}

}
