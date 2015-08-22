package com.learning.cucumber;

import org.apache.log4j.Logger;

import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HolyDeveloper {
	Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");

	@Given("^I work in ([^\"]*)$")
	public void  I_am(String type){
		APPLICATION_LOGS.debug("***************");
		APPLICATION_LOGS.debug("I am a "+ type +" developer");
	}
	
	
	
	@When("I meet ([^\"]*)")
	public void I_meet(String person1){
		APPLICATION_LOGS.debug("I meet "+ person1);
	}
	
	@Then("I ([a-zA-Z]{1,})")
	public void I_(String reaction){
		APPLICATION_LOGS.debug("I "+ reaction);
	}
	
	@But("he is a ([^\"]*) person")
	public void He_is_a(String personality){
		APPLICATION_LOGS.debug("He is a "+personality+" person" );
	}

}
