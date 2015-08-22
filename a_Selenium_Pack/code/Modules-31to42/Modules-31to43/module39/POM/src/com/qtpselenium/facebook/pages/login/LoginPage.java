package com.qtpselenium.facebook.pages.login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qtpselenium.facebook.base.Page;
import com.qtpselenium.facebook.pages.inbox.LandingPage;
import com.qtpselenium.facebook.pages.inbox.TopMenu;
import com.qtpselenium.util.ErrorUtil;

public class LoginPage extends Page{
	// null - if login is not success
	// LandingPage - if login is success
	public LandingPage doLogin(String userName,String password){
		try{
			Assert.assertEquals("XXXWelcome to Facebook — Log in, sign up or learn more", driver.getTitle());
			}catch(Throwable t){
			 Page.takeScreenshot("Login.jpg");
			}
		driver.get(CONFIG.getProperty("testSiteLadingPageURL"));
		System.out.println(isElementPresent("//*[@id='email']"));
		input("EMAIL",userName);
		input("PASSWORD",password);
		click("LOGIN_BUTTON");
		if(isElementPresent("go_to_profile"))
			return new LandingPage();
		else 
			return null;
		
		// initialize TopMenu
		//topMenu = new TopMenu();
	}
	// default - correct , username password
	public LandingPage doLogin(){
		
		return doLogin(CONFIG.getProperty("defaultUserName"),CONFIG.getProperty("defaultPassword"));
	}
	
	
	public void doRegister(){
		
	}

}
