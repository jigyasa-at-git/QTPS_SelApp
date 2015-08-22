package tests.suite1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tests.TestBase;
import util.TestUtil;
@RunWith(Parameterized.class)
public class LoginTest extends TestBase{
	
	public String username;
	public String password;
	public String positiveData;
	
	public LoginTest(String username,String password,String positiveData){
		this.username=username;
		this.password=password;
		this.positiveData=positiveData;
	}
	
	@Before
	public void beforeTest() throws IOException{
		initialize();
		// xlsx file
		if(TestUtil.isSkip("LoginTest"))
			Assume.assumeTrue(false);
		
	}
	
	
	@Test
	public void loginTest() throws InterruptedException{
		System.out.println("Executing login test");
		// selenium code
		driver.get(CONFIG.getProperty("testSiteName"));
		// login
		TestUtil.doLogin(username, password);
		if(!isLoggedIn & positiveData.equals("Y")){
			// report error
			TestUtil.takeScreenShot("loginerror_1");
			System.err.println("Not able to login with right cred - "+username +" -- "+password);
			Assert.assertTrue("Not able to login with right cred - "+username +" -- "+password,false);
		}else if(isLoggedIn & positiveData.equals("N")){
			TestUtil.takeScreenShot("loginerror_2");
			// report error - able to login with wrong cred
			System.err.println("Able to login with wrong cred - "+username +" -- "+password);
			Assert.assertTrue("Able to login with wrong cred - "+username +" -- "+password,false);
		}
		
		TestUtil.logout();
	}
	
	@Parameters
	public static Collection<Object[]> dataSupplier(){
		// read data from xls file and write in into Object array.
		Object[][] data = TestUtil.getData("LoginTest");
		return Arrays.asList(data);

	}

}
