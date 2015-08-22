package testscript;
//http://www.vogella.de/articles/JavaRegularExpressions/ar01s05.html
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
// testng
import org.testng.Assert;

public class Keywords extends DriverScript{
	
	
	// navigate
	public static String navigate(){
		APPICATION_LOGS.debug("Executing Navigate");
		if(wbdv == null){
			if(CONFIG.getProperty("testBrowser").equals("Firefox")){
				wbdv = new FirefoxDriver();
				driver = new EventFiringWebDriver(wbdv);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			//else
		}
		driver.navigate().to(CONFIG.getProperty(object));
		return "Pass";
		
	}
	
	public static String clickLink(){
		APPICATION_LOGS.debug("Executing clickLink");
		try{
		driver.findElement(By.xpath(OR.getProperty(object))).click();
		}catch(Throwable t){
			// report error
			APPICATION_LOGS.debug("Error while clicking on link -"+ object + t.getMessage());
			return "Fail - Link Not Found";
		}
		
		return "Pass";
	}
	
	public static String verifyText(){
		APPICATION_LOGS.debug("Executing verifyText");
		String expected=APPTEXT.getProperty(object);
		String actual=driver.findElement(By.xpath(OR.getProperty(object))).getText();
		APPICATION_LOGS.debug(expected);
		APPICATION_LOGS.debug(actual);
		try{
			Assert.assertEquals(actual.trim() , expected.trim());
		}catch(Throwable t){
			// error
			APPICATION_LOGS.debug("Error in text - "+object);
			APPICATION_LOGS.debug("Actual - "+actual);
			APPICATION_LOGS.debug("Expected -"+ expected);
			return "Fail -"+ t.getMessage(); 
			
		}
		
		return "Pass";
		
	}
	
	public static String input(){
		
		APPICATION_LOGS.debug("Executing input Keyword");
		// extract the test data
		String data =testData.getCellData(currentTest, data_column_name , testRepeat);
		
		
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while wrinting into input -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	public static String clickButton(){
		APPICATION_LOGS.debug("Executing clickButton Keyword");
		
		
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	public static String select(){
		APPICATION_LOGS.debug("Executing select Keyword");
		// extract the test data
		String data =testData.getCellData(currentTest, data_column_name , testRepeat);
		
		
		
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while Selecting from droplist -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	public static String clickCheckBox(){
     APPICATION_LOGS.debug("Executing clickCheckBox Keyword");
		
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on checkbox -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	public static String Wait() throws NumberFormatException, InterruptedException{
	     APPICATION_LOGS.debug("Executing wait Keyword");
	  // extract the test data
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			
	     Thread.sleep(Long.parseLong(data));
	     return "Pass";
	}
		
	

}
