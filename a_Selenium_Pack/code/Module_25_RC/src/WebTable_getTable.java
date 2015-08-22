import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class WebTable_getTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Selenium selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://www.timeanddate.com");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		//selenium.setSpeed("2000");
		selenium.open("/worldclock/");
		
		System.out.println(selenium.getTable("xpath=html/body/table[1].2.3"));
		
		
		
		
		
		
		
		
	}

}
