package suite1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import util.TestUtil;

import base.TestBase;

@RunWith(Parameterized.class)
public class CreateLeadTest extends TestBase{
	
	String salutation;
	String first_name;
	String last_name;
	String company;
	String lead_status;
	
	private static int testRepeatcount=0;
	
	public CreateLeadTest(String salutation, 
			String first_name,
			String last_name,
			String company,
			String lead_status){
		
		this.salutation=salutation;
		this.first_name=first_name;
		this.last_name=last_name;
		this.company=company;
		this.lead_status=lead_status;


	}
	
	
	@Before
	public void beforeExecution() throws Exception{
		//initialize();
		// runmode of the test Y OR N
		if(TestUtil.isSkip(datatable_suite1, "CreateLeadTest")){
			// skip the test
			Assume.assumeTrue(false);
		}
	}
	
	@Test
	public void testCreateLead() throws Exception{
		testRepeatcount++;
		System.out.println("xx" +testRepeatcount);
		APP_LOGS.debug("Starting Create Lead Test Execution");
		APP_LOGS.debug(CONFIG.getProperty("browserType"));
		APP_LOGS.debug(salutation + "  ---- " +first_name +" -- "+last_name+" -- "+company+" -- "+lead_status);
		selenium.click(XPATH_MAP.getProperty("new_label"));
		selenium.click(XPATH_MAP.getProperty("create_lead_link"));
		selenium.waitForPageToLoad("30000");
		//  fill the form to create the lead
		selenium.select(XPATH_MAP.getProperty("saluation_lead"),"label="+salutation);
		selenium.type(XPATH_MAP.getProperty("firstName_input"), first_name);
		selenium.type(XPATH_MAP.getProperty("lastName_input"), last_name);
		selenium.type(XPATH_MAP.getProperty("company_input"), company);
		selenium.select(XPATH_MAP.getProperty("lead_satus"),"label="+lead_status);
		// click the button to create lead
		selenium.click(XPATH_MAP.getProperty("saveLead_button"));
		selenium.waitForPageToLoad("30000");
		TestUtil.takeScreenShots("createLeadSuccess_"+testRepeatcount);
  // assertions
		
	}
	
	
		@Parameters
		public static Collection<Object[]> getData() throws Exception{
			initialize();
			// read the data from xls file to Object array
			Object data[][] = TestUtil.getData(datatable_suite1, "CreateLeadTest");
			return Arrays.asList(data);
		}

}
