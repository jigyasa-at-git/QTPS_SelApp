package com.salesforce.login;

import com.salesforce.connector.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Login {
	
	WebConnector con = new WebConnector();
	
	@Given("^I open \"([a-zA-Z]{1,})\"$")
	public void openBrowserandNavigate(String browser){
		System.out.println("Opening browser "+ browser);
		con.openBrowser(browser);
	}
	
	@And("^I navigate to \"([a-zA-Z]{1,})\"$")
	public void navigate(String url){ 
		System.out.println("Navigating " + url);
		con.navigate(url);
	}
	
	@And("^I click on \"([a-zA-Z]{1,})\"$")
	public void click(String xpathKey){
		con.click(xpathKey);
	}
	
	@And("^I enter \"([a-zA-Z]{1,})\" as \"([a-zA-Z]{1,})\"$")
	public void input(String xpathKey,String value){
		con.input(xpathKey, value);
	}
	
	

}
