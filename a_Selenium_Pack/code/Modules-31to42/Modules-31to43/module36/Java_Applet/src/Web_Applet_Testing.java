import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Web_Applet_Testing {
	
	@Test
	public void testAppletFeatures() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("http://qtpselenium.com/applet/test.html");
		Thread.sleep(10000L);
		String text  = (String)((JavascriptExecutor) driver).executeScript(" return document.SimpleMessageApplet.getWelcomeMessage();");
		((JavascriptExecutor) driver).executeScript("		document.SimpleMessageApplet.setTextMessage('Any Rand');");
		System.out.println(text);
	}

}
