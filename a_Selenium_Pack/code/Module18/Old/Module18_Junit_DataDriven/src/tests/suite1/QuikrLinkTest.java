package tests.suite1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import tests.TestBase;
import util.TestUtil;
@RunWith(Parameterized.class)
public class QuikrLinkTest extends TestBase{
	
	@Rule
	public ErrorCollector errCollector = new ErrorCollector();
	
	@Before
	public void beforeTest() throws IOException{
		initialize();
		// xlsx file
		if(TestUtil.isSkip("QuikrLinkTest"))
			Assume.assumeTrue(false);
		
	}
	
	
	
	
	@Test
	public void linkTest() throws InterruptedException{
		String xpath_start=OR.getProperty("electronics_start_link");
		String xpath_end=OR.getProperty("electronics_end_link");
	    driver.get(CONFIG.getProperty("testSiteName"));

		System.out.println("Starting linkTest");
		
		//		for(int i=0 ;i<= 16 ; i++){
		for(int i=0 ;i<= 2 ; i++){
			try{
			driver.findElement(By.xpath(xpath_start+ i + xpath_end)).click();
			// wait for next page
			Thread.sleep(5000L);
			//System.out.println(driver.getTitle());
			driver.findElement(By.xpath(OR.getProperty("nextpage_heading")));
		    driver.get(CONFIG.getProperty("testSiteName"));
			}
		    catch(Throwable t){
		    	// error collector
		    	System.err.println("error while clicking on link - " + i);
				TestUtil.takeScreenShot("linkerr_"+i);
		    	errCollector.addError(t);
		    	driver.get(CONFIG.getProperty("testSiteName"));
		    }
		}
	}
	
	@Parameters
	public static Collection<Object[]> dataSupplier(){
		Object[][] data = TestUtil.getData("QuikrLinkTest");
		return Arrays.asList(data);
	}
	
	}


