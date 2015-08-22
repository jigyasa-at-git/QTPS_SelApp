package tests;
//www.sejsoft.com/downloads/jars.rar
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	@BeforeTest
	public void openConnection(){
		// db connection
		System.out.println("connected to database");
	}
	
	@AfterTest
	public void closeConnection(){
		System.out.println("closing the database connection");
	}
	
	@BeforeMethod
	public void openBrowser(){
		// selenium
		System.out.println("Opening browser");
	}
	
	@AfterMethod
	public void closeBrowser(){
		System.out.println("Closing browser");

	}
	
	@Test // annotation - represents test case
	public void testLogin(){
		// selenium code
		System.out.println("Executing logintest");
	}
	
	
	
	@Test
	public void testRegister(){
		System.out.println("Testing the registration");
	}

}
