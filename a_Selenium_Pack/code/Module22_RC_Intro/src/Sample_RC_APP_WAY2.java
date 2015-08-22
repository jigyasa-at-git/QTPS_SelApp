import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

// http://localhost:4444/selenium-server/driver/?cmd=shutDown

public class Sample_RC_APP_WAY2 {

	
	public static void main(String[] args) {
     
		
		Selenium selenium = new DefaultSelenium("localhost",4444,
				"*iexplore","http://gmail.com");
		selenium.setSpeed("2000");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		selenium.open("/"); // wait till the whole page has loaded
		selenium.type("xpath=//html/body/table[2]/tbody/tr/td[2]/div/form[1]/div/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/input[11]", "hello");
		selenium.type("//input[@id='Passwd']", "world");
		selenium.click("//*[@id='signIn']");
		
		System.out.println(selenium.getText("//*[@id='leftcolumn']/a[2]"));
		selenium.click("//*[@id='leftcolumn']/a[2]");
		
		selenium.close();
		
		
		
		
		
		
	}

}
