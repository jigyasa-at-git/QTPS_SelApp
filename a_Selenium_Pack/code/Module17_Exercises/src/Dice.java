import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Dice {
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://dice.com");
		
		driver.findElement(By.xpath("//*[@id='FREE_TEXT']")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id='searchSubmit']")).click();
		
		
		int i=2;
		while(isElementPresent("//div[@class='yui-g']/div/div[@class='pageProg']/a[text()='"+i+"']")){
			driver.findElement(By.xpath("//div[@class='yui-g']/div/div[@class='pageProg']/a[text()='"+i+"']")).click();
			// extract/click all search results
			
			i++;
			
			
		}
		
	}
	
	public static boolean isElementPresent(String xpathExp){
		int count = driver.findElements(By.xpath(xpathExp)).size();
				if(count==0)
					return false;
				else
					return true;
	}

}
