import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;


public class HTML_Unit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// http://code.google.com/p/selenium/wiki/HtmlUnitDriver
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_10);
		driver.get("http://gmail.com");
		System.out.println(driver.getTitle());
	}

}
