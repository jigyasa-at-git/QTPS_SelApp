package tests.suite1;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tests.TestBase;
import util.TestUtil;

@RunWith(Parameterized.class)
public class RegistrationTest extends TestBase{
	public String name;
	public String id;
	public String password;
	public String email;
	public String city;
	public String positiveData;

	
	public RegistrationTest(String name, String id, String password
							, String email, String city,String positiveData){
		this.id=id;
		this.name=name;
		this.password=password;
		this.email=email;
		this.city=city;
		this.positiveData=positiveData;
	}
	
	
	

	@Before
	public void beforeTest() throws IOException{
		System.out.println("Initializing the system");
		initialize();

		// xlsx file
		if(TestUtil.isSkip("RegistrationTest"))
			Assume.assumeTrue(false);
	}
	
	@Test
	public void registerTest(){
		System.out.println("register");
		
	    driver.get(CONFIG.getProperty("testSiteName"));
		getObject("register_link").click();
		getObject("register_name_input").sendKeys(name);
		getObject("register_id_input").sendKeys(id);
		getObject("register_password_input").sendKeys(password);
		getObject("register_email_input").sendKeys(email);
		getObject("register_city_dropdown").sendKeys(city);
		
		getObject("register_above18_chk").click();
		getObject("register_button").click();
		WebElement thkYou=null;
		try{
		 thkYou = driver.findElement(By.xpath(CONFIG.getProperty("registration_success_text")));
		}catch(Throwable t){
			TestUtil.takeScreenShot("regerror_1");
			if(positiveData.equals("Y")){
				System.err.println("error in registration");
				Assert.assertTrue("Not able to register with correct data", false);
			}
		}
		
		if(positiveData.equals("N")){
			System.err.println("error in registration");
			TestUtil.takeScreenShot("regerror_2");
			Assert.assertTrue("Able to register with wrong data", false);
		}
	}
	
	@Parameters
	public static Collection<Object[]> dataSupplier(){
		System.out.println("Collecting data");
		// read data fromthkYou xls file and write in into Object array.
		Object[][] data = TestUtil.getData("RegistrationTest");
		// 1st row
		/*data[0][0]="qtpseleniumtest1";
		data[0][1]="qtpseleniumtest1";
		data[0][2]="password1234";
		data[0][3]="qtpseleniumsample@gmail.com";
		data[0][4]="Delhi";
		
		// 2nd row
		data[1][0]="qtpseleniumtest2";
		data[1][1]="qtpseleniumtest2";
		data[1][2]="password1234";
		data[1][3]="qtpseleniumsample@gmail.com";
		data[1][4]="Delhi";*/
		
		return Arrays.asList(data);

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
