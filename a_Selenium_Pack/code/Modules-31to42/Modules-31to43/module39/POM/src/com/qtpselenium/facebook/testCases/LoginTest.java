package com.qtpselenium.facebook.testCases;
// if test fails - you need report error and continue
// take screenshot
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.base.Page;
import com.qtpselenium.facebook.pages.inbox.LandingPage;
import com.qtpselenium.facebook.pages.login.LoginPage;
import com.qtpselenium.util.ErrorUtil;
import com.qtpselenium.util.TestUtil;

public class LoginTest {

	
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,String> data){
		
		
		// check the runmode of test case
		if(!TestUtil.isExecutable("LoginTest",Page.xls1))
		 throw new SkipException("Runmode set to NO");
		
		// check runmode for data set
		if(!data.get("Runmode").equals("Y"))
			 throw new SkipException("Runmode set to NO for the data set");

		System.out.println(data.get("Runmode")+" -- "+data.get("Username") +" -- "+data.get("Password"));

		// logout if loggedin
		if(Page.isLoggedIn){
			Page.topMenu.Logout();
			Page.isLoggedIn=false;
		}
		
		// temp
		String testDataType=data.get("Flag");
		LoginPage loginPage = new LoginPage();
		
		
		LandingPage page= loginPage.doLogin(data.get("Username"), data.get("Password"));
		// error
		if(testDataType.equals("Y") & page==null){
			try{
			Assert.assertTrue(false, "Not able to login with correct data ");
			}catch(Throwable t){
				Page.takeScreenshot("Login");
				ErrorUtil.addVerificationFailure(t);
			}
			Page.isLoggedIn=false;
			return;
		}
		else if(!testDataType.equals("Y") & page!=null ){
			Assert.assertTrue(false, "Able to login with incorrect data ");
			Page.isLoggedIn=false;	
			return;
		}
		
		if(testDataType.equals("Y"))
		 Page.isLoggedIn=true;
		else
		 Page.isLoggedIn=false;

		

	}
	
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("LoginTest", Page.xls1);
	}
	
	

}
