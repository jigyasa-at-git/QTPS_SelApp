package com.qtpselenium.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qtpselenium.util.Constants;
import com.qtpselenium.util.ErrorUtil;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(xpath=Constants.username)
	public WebElement username;
	@FindBy(xpath=Constants.password)
	public WebElement password;
	
	
	public LoginPage(WebDriver dr){
		driver=dr;
	}

	
	
	public LandingPage doLogin(String uName, String pWord){
		driver.get("http://facebook.com"); // config.prop
		// verify title
		try{
		Assert.assertEquals(driver.getTitle(), Constants.titleHomePage);
		}catch(Throwable e){
			System.out.println("error---");
			// tell ur reports - error has come
			ErrorUtil.addVerificationFailure(e);
			// capture screenshot
		}
		username.sendKeys(uName);
		password.sendKeys(pWord);
		password.sendKeys(Keys.ENTER);
		//validate login - successful
		int count = driver.findElements(By.xpath(Constants.profileLink)).size();
		if(count==0)// not logged in
			return null;
		else{//logged in success
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		return landingPage;
		}
		
	}

}
