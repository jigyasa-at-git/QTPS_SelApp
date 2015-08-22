package com.qtpselenium.app.salesforce.testcases;

import java.util.List;

import org.junit.Assert;

import com.qtpselenium.app.salesforce.util.WebConnector;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MenuTest {
	
	WebConnector selenium =WebConnector.getInstance();
	// step layer
	
	
	@Given("^I am logged in \"([^\"]*)\"$")
	public void I_am_logged_in(String browser){
		// check if logged in the browser.. if not.. login
		
		selenium.openBrowser(browser);
		if(!selenium.isLoggedIn()){
			selenium.log("Opening browser and logging in as a default user");
			// login the user - your task
			selenium.doDefaultLogin();
		}
	}
	
	@Then("^All tabs on menu should be present$")
	public void All_tabs_on_menu_should_be_present(DataTable table){
		List<String> names= table.asList(String.class);
		System.out.println("*************************");
		for(int i=0;i<names.size();i++){
			selenium.log("Checking  " + names.get(i));
			Assert.assertTrue("Element not found in Menu "+names.get(i), selenium.isElementPresent(names.get(i)));
		}
		
	}
	
	
	@And("^\"([^\"]*)\" element should be present$")
	public void Element_Should_Be_Present(String object){
		selenium.log("Element_Should_Be_Present  " + object);
		Assert.assertTrue("Object not found "+object , selenium.isElementPresent(object));
	}
	
	
	
	
	
	
	
	
	
	

}
