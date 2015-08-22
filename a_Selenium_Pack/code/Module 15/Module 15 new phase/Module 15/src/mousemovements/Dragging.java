package mousemovements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Dragging {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://americangolf.co.uk/golf-clubs?viewall=true&pmin=10&pmax=1130");
		
		Actions act = new Actions(driver);
		
		WebElement point = driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[2]/div[1]/div[1]/a[2]"));
		act.dragAndDropBy(point, -100, 0).build().perform();	

	}

}
