package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingAssertions {
	
	
	@Test
	public void testGoogleSearch(){
		// open google.com
		String expected_title="Google1";
		String acual_title="Google"; //  selenium
		System.out.println("before assertion");
		try{
			Assert.assertEquals(expected_title, acual_title);
		}catch(Throwable t){
			// recovered
			// java code to fail the test
			System.out.println("error");
		}
		System.out.println("After assertion");
		
		Assert.assertTrue(4>13, "Error coming because of xyz reason");
	}

}
