package com.qtpselenium.testcases;



import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.pages.FriendList;
import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.LoginPage;
import com.qtpselenium.facebook.pages.PersonalProfile;
import com.qtpselenium.util.TestUtil;
import com.qtpselenium.util.Xls_Reader;

public class LoginTest extends TestBase{
	LandingPage landingPage=null;
	
	@BeforeSuite
	public void init(){
		initConfigurations();
		initDriver();
	}
	
	
	
	@Test(dataProvider="getLoginData")
	public void loginTest(Hashtable<String,String> data){
		if(!TestUtil.isExecutable("LoginTest", xls) || data.get("Runmode").equals("N"))
		throw new SkipException("Skipping the test");
		
		System.out.println("************************************************");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		landingPage = lp.doLogin(data.get("Username"),data.get("Password"));
		Assert.assertTrue(landingPage!=null, "Could not login");
		isLoggedIn=true;
		APPLICATION_LOGS.debug("logged in");
		landingPage.gotoProfile();
		APPLICATION_LOGS.debug("In profile page");
		
		// wrong username/password
		// return type	}

	}
	@DataProvider
	public Object[][] getLoginData(){
		return TestUtil.getData("LoginTest", xls);
	}
	
	
	@Test(dependsOnMethods={"loginTest"})
	public void findFriend(){
		String friendName="Sadil Katoch";
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\data\\Test Cases.xlsx");
		if(!TestUtil.isExecutable("FindFriendTest", xls))
		throw new SkipException("Skipping the test");
		
		PersonalProfile personalProfile = landingPage.gotoProfile();
		FriendList frdList = personalProfile.loadFriendList();
		boolean b = frdList.findAfriend(friendName);
		Assert.assertTrue(b, "Friend not found "+ friendName);
	}
	
	
}
