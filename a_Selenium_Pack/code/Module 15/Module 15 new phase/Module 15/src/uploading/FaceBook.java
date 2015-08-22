package uploading;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBook {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("its.thakur@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Enjoy@123");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='pagelet_welcome_box']/div/div/div/div[2]/a[1]")).click();
		WebElement profileSelector = driver.findElement(By.xpath("//div[@id='fbProfilePicSelector']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profileSelector).build().perform();
		
		
		driver.findElement(By.xpath("//div[@id='fbProfilePicSelector']/div/a/img")).click();

		//driver.findElement(By.xpath("//input[@name='file']")).sendKeys("f://ashish.jpg");
		//driver.findElement(By.xpath("//input[@name='file']")).click();
		
		act.moveToElement(driver.findElement(By.xpath("//ul[@role='menu']/li[3]/a/span/span/form/div/a"))).clickAndHold(driver.findElement(By.xpath("//ul[@role='menu']/li[3]/a/span/span/form/div/a"))).build().perform();
		Thread.sleep(5000);
		act.release(driver.findElement(By.xpath("//ul[@role='menu']/li[3]/a/span/span/form/div/a"))).build().perform();
		
		Process process = new ProcessBuilder(System.getProperty("user.dir")+"\\src\\uploading\\temp.exe",
                "F:\\ashish.jpg", "Open").start();

	}
}




/*
 * act.moveToElement(driver.findElement(By.xpath("//ul[@role='menu']/li[3]/a/span/span/form/div/a"))).clickAndHold(driver.findElement(By.xpath("//ul[@role='menu']/li[3]/a/span/span/form/div/a"))).build().perform();
		Thread.sleep(5000);
		act.release(driver.findElement(By.xpath("//ul[@role='menu']/li[3]/a/span/span/form/div/a"))).build().perform();
		*/
