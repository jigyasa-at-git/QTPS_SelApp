package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
	
	
	@Test(priority=1,dataProviderClass=Data_Provider.class,dataProvider="loginTestDataProvider")
	public void testLogin(String username,String psw){
		//Assert.assertEquals("A", "B");
		System.out.println("Login Test");
		
	}
	
	@Test(priority=2,dependsOnMethods={"testLogin"})
	public void testChangePassword(){
		System.out.println("Password change Test");
		
	}
	
	@Test(priority=3,dependsOnMethods={"testLogin","testChangePassword"})
	public void logout(){
		System.out.println("Logout test");
		
	}
	
	
	

}
