package com.learning.cucumber;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class HolyTester {
	Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	
	
	@Given("^I am a \"([a-zA-Z]{1,})\" tester$")
	public void I_am_a_bad_tester(String testerType,DataTable table){
		
		List<Map<String,String>> data = table.asMaps();
		
		APPLICATION_LOGS.debug("@Given - I am a "+testerType+" tester in "+ data.get(0).get("industry") +" industry in country "+ data.get(0).get("country"));
		APPLICATION_LOGS.debug("@Given - I am a "+testerType+" tester in "+ data.get(1).get("industry") +" industry in country "+ data.get(1).get("country"));
	}
	
	@When("^I go to work$")
	public void I_go_to_work(){
		APPLICATION_LOGS.debug("@When - I go to work");
	}
	
	@Then("^I \"([a-zA-Z]{1,})\" it$")
	public void I_mess_with_it(String workOutput){
		APPLICATION_LOGS.debug("@Then - I "+workOutput+" it");
	}
	
	@And("^My boss \"([a-zA-Z]{1,})\" me$")
	public void My_boss_fires_me(String boss,DataTable table){
		List<Map<String,String>> data = table.asMaps();

		APPLICATION_LOGS.debug("@And - My boss in country "+data.get(0).get("country")+" "+boss+" me");
		APPLICATION_LOGS.debug("@And - My boss in country "+data.get(1).get("country")+" "+boss+" me");

	}
	
	
	
	@But("^The developer \"([a-zA-Z]{1,})\" me$")
	public void The_developer_likes_me(String dev){
		System.out.println("@But - The developer "+dev+" me");
	}
	
	

}
