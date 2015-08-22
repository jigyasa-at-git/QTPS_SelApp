package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
Soap@123
public class TestApplication {
	
	@BeforeClass
	public static void begin(){
		System.out.println("Before everything");
	}
	
	@AfterClass
	public static void end(){
		System.out.println("After everything");
	}
	
	@Before
	public void init(){
		// xls file - runmode
		//Assume.assumeTrue(false);
		
		
		
		System.out.println("before test");
	}
	
	@After
	public void close(){
		System.out.println(" after test");
	}
	
	//@Ignore
	@Test
	public void testLogin(){		
		// selenium code to execute test login
		System.out.println("Executing login test");
		
	}
	
	@Test
	public void testRegister(){		
		// selenium code to execute test registration
		System.out.println("Executing Registration test");
		
	}
	
	
	
	

}
