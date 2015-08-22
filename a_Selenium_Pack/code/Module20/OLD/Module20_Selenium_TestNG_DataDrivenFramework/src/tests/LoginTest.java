package tests;


import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ErrorUtil;
import util.TestUtil;

public class LoginTest extends TestBase{
	@BeforeTest
	public void isSkipped(){
		if(TestUtil.isSkip("LoginTest"))
			throw new SkipException("Runmode set to No");
	}
	
	@Test(dataProvider="getData")
	public void testLogin(String username, String password, String testType ) throws InterruptedException, IOException{
		
		APPLICATION_LOGS.debug("Starting the Login test");
		TestUtil.login(username,password);
		if((!loggedIn) & Boolean.valueOf(testType)){ // not able to login with valid credentials
			// error report
			TestUtil.takeScreenShot("LoginTest_positive");
			ErrorUtil.addVerificationFailure(new Throwable("not able to login with valid credentials"));
			APPLICATION_LOGS.debug("LOGIN ERROR - NOT ABLE TO LOGINWITH CORRECT CREDENTIALS");
			return;			
		}else if((loggedIn) & (!Boolean.valueOf(testType))){//
			APPLICATION_LOGS.debug("LOGIN ERROR -  ABLE TO LOGIN WITH INCORRECT CREDENTIALS");
			// report error
			TestUtil.takeScreenShot("RegisterTest_negative");
			ErrorUtil.addVerificationFailure(new Throwable("ABLE TO LOGIN WITH INCORRECT CREDENTIALS"));

				
		}
		
		TestUtil.logout();
		
		if(loggedIn){
			// report error
		}
		
	    // login
		
	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("LoginTest");
		/* 1st row - positive
		data[0][0]="regSel2";
		data[0][1]="password1234";
		data[0][2]=true;
		
		
		// 2nd row - negative
		data[1][0]="Ashish";
		data[1][1]="regSel1";
		data[1][2]=false;
		
		return data;
		*/
		
		
		
		
		
		
		
	}
}
