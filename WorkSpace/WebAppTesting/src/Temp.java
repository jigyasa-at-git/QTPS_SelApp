import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Temp {

	public static void main(String[] args) {
		// finding user agent for mozilla
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String ua = (String)js.executeScript("return navigator.userAgent");
		System.out.println(ua);

	}

}
