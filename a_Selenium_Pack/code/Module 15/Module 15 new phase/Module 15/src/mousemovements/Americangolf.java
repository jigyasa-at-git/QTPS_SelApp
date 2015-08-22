package mousemovements;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Americangolf {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//FirefoxProfile fp = new FirefoxProfile();
		//fp.setEnableNativeEvents(true);
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://americangolf.co.uk ");
		
		Actions act = new Actions(driver);
		
		WebElement golfClubsMenu = driver.findElement(By.xpath("//*[@id='navigation']/nav/ul/li[1]/a"));
		act.moveToElement(golfClubsMenu).build().perform();
		//Thread.sleep(3000);
		//WebElement ladies = driver.findElement(By.xpath("//*[@id='navigation']/nav/ul/li[1]/div/div[1]/ul/li[2]/a"));
		//act.moveToElement(ladies).build().perform();

		WebElement box = driver.findElement(By.xpath("//*[@id='CLUBS_1']/div[1]"));
		List<WebElement> links = box.findElements(By.tagName("a"));
		
		System.out.println("Total links - "+ links.size());
		int total=links.size();
		Random r = new Random();
		links.get(r.nextInt(total)).click();
		
		//Select

	}

}
