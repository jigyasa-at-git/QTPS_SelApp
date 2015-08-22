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
public class CreateTask extends TestBase{
	
	String salutation;
	String first_name;
	String last_name;
	String company;
	String lead_status;
	
	public CreateTask(String salutation, 
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
		if(TestUtil.isSkip(datatable_suite1, "CreateTask")){
			// skip the test
			Assume.assumeTrue(false);
		}
	}
	
	@Test
	public void testCreateLead() throws Exception{
		APP_LOGS.debug("Starting Create Lead Test Execution");
		APP_LOGS.debug(CONFIG.getProperty("browserType"));
		APP_LOGS.debug(salutation + "  ---- " +first_name +" -- "+last_name+" -- "+company+" -- "+lead_status);
		
  // assertions
		
	}
	
	
		@Parameters
		public static Collection<Object[]> getData() throws Exception{
			initialize();
			// read the data from xls file to Object array
			Object data[][] = TestUtil.getData(datatable_suite1, "CreateTask");
			return Arrays.asList(data);
		}

}
