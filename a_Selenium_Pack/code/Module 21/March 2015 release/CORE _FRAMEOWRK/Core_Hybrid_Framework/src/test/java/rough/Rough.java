package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rough {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://in.rediff.com");
		driver.findElement(By.xpath("//a[@id='xxxxxx']")).click();

	}

}
