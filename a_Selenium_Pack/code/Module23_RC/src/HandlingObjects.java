import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class HandlingObjects {


	public static void main(String[] args) {

		Selenium selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://www.w3schools.com");
		selenium.start();
		selenium.setSpeed("2000");
		selenium.open("/html/html_forms.asp");
		// check and uncheck - click
		selenium.click("xpath=//html/body/div[1]/div[1]/div[4]/div[2]/form[4]/input[1]");
		selenium.uncheck("xpath=//html/body/div[1]/div[1]/div[4]/div[2]/form[4]/input[1]");
		
		System.out.println(selenium.getText("//*[@id='leftcolumn']/a[2]"));
		selenium.click("//*[@id='leftcolumn']/a[2]");
		selenium.waitForPageToLoad("30000");
		System.out.println("Page loaded successfully");
		System.out.println(selenium.getTitle());
		selenium.close();
		selenium.stop();
		
		
	}

}
