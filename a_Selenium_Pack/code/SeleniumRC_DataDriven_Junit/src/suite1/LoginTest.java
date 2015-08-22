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
public class LoginTest extends TestBase{
	
	String username;
	String password;
	String correctness_flag;
	
	public LoginTest(String username, String password,String correctness_flag){
		this.username=username;
		this.password=password;
		this.correctness_flag=correctness_flag;
	}
	
	
	@Before
	public void beforeExecution() throws Exception{
		//initialize();
		// runmode of the test Y OR N
		if(TestUtil.isSkip(datatable_suite1, "LoginTest")){
			// skip the test
			Assume.assumeTrue(false);
		}
	}
	
	@Test
	public void testLogin() throws Exception{
		APP_LOGS.debug("Starting Login Test Execution");
		System.out.println(CONFIG.getProperty("browserType"));
		APP_LOGS.debug(username + "  ---- " +password +" -- "+correctness_flag);
		
		selenium.open("/");
		selenium.click(XPATH_MAP.getProperty("login_link"));
		selenium.waitForPageToLoad("30000");
		selenium.type(XPATH_MAP.getProperty("login_username_input"),username );
		selenium.type(XPATH_MAP.getProperty("login_password_input"),password );
		selenium.click(XPATH_MAP.getProperty("login_button"));
		selenium.waitForPageToLoad("30000");
		try{
		Assert.assertEquals("salesforce.com - Professional Edition", selenium.getTitle());
		// wrong set of data
				if(correctness_flag.equals("N")){
					// report error
					errCol.addError(new Exception("Logged in with wrong set of username/password"));

				}
		}catch(Throwable t){
			// correct data
			if(correctness_flag.equals("Y")){
				// report error
				errCol.addError(new Exception("Not able to Log in with correct set of username/password"));
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
		@Parameters
		public static Collection<Object[]> getData() throws Exception{
			initialize();
			// read the data from xls file to Object array
			Object data[][] = TestUtil.getData(datatable_suite1, "LoginTest");
			return Arrays.asList(data);
		}

}
