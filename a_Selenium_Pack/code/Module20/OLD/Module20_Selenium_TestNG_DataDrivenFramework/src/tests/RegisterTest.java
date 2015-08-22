package tests;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ErrorUtil;
import util.TestUtil;


public class RegisterTest extends TestBase{
	
	
	@BeforeTest
	public void isSkipped(){
		if(TestUtil.isSkip("RegisterTest"))
			throw new SkipException("Runmode set to No");
	}
	
	@Test(dataProvider = "getData")
	public void testRegistration(String name, String userID, String password,String email,String City,String testType ) throws IOException{
		APPLICATION_LOGS.debug("Starting the register test");
	    driver.get(config.getProperty("testSiteURL"));
		getObject("register_link").click();
		APPLICATION_LOGS.debug("Entering the registration parameters");
		getObject("register_name").sendKeys(name);
		getObject("register_id").sendKeys(userID);
		getObject("register_password").sendKeys(password);
		getObject("register_email").sendKeys(email);
		getObject("register_dropdown").sendKeys(City);
		
		getObject("register_above18").click();
		getObject("register_button").click();
		
		if(Boolean.valueOf(testType)){
			// next confirmation page
			String registrationSuccess= getObject("register_success").getText();
			if(registrationSuccess != null){
			// compare texts
				try{
				Assert.assertEquals("Thank You for registering on Quikr", registrationSuccess);
				}catch(Throwable t){
					ErrorUtil.addVerificationFailure(t);
					TestUtil.takeScreenShot("RegisterTest_poitive");
					APPLICATION_LOGS.debug("Error in registration "+t.getMessage());
				}
			}
		}else{
			String actualVal =getObject("register_userid_taken").getText();
			try{
				Assert.assertEquals("This User Id has been taken 1", actualVal);
				}catch(Throwable t){
					TestUtil.takeScreenShot("RegisterTest_negative");
					ErrorUtil.addVerificationFailure(t);
					APPLICATION_LOGS.debug("Error in negative data "+ t.getMessage());
				}
		}
			
	}
	
	
	@DataProvider
	public Object[][] getData(){

		return TestUtil.getData("RegisterTest");
		/* 1st row 
		data[0][0]="Ashish";
		data[0][1]="regSel2";
		data[0][2]="password1234";
		data[0][3]="regtestsel2@gmail.com";
		data[0][4]="Delhi";
		data[0][5]=true;
		
		
		// 2nd row
		data[1][0]="Ashish";
		data[1][1]="regSel1";
		data[1][2]="password1234";
		data[1][3]="regtestsel1@gmail.com";
		data[1][4]="Delhi";
		data[1][5]=false;
		
		return data;
		
		*/
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
