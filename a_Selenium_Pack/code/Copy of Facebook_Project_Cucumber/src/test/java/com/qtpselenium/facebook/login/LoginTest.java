package com.qtpselenium.facebook.login;




import org.junit.Assert;

import com.qtpselenium.facebook.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginTest {
	WebConnector application=new WebConnector();
	
	@Given("^I go to facebook on \"([a-zA-Z]{1,})\"$")
	public void gotoFacebook(String browserType){
		System.out.println("Going to facebook on "+browserType);
		application.openBrowser(browserType);
		application.navigate("http://facebook.com");
		
		
	}
	
	@And("I enter \"([a-zA-Z]{1,})\" as \"([^\"]*)\"$")
	public void input(String object,String data){
		System.out.println("Entering in "+ object +" value "+ data);
		application.input(object,data);
	}
	
	@And("I click on \"([a-zA-Z]{1,})\"$")
	public void click(String object){
		System.out.println("Clicking "+ object);
		application.click(object);
	}
	
	@Then("login should be \"([a-zA-Z]{1,})\"$")
	public void verifyLogin(String expectedReslt){
		System.out.println("Expected esult  - "+ expectedReslt);
		Assert.assertTrue("Login not successfull", application.isElementPresent("profileimage"));
		
		
	}

}
