import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Facebook1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://facebook.com");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("its.thakur@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Temp@123");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[@id='pagelet_welcome_box']/div/a")).click();
		driver.findElement(By.xpath("//div[@id='fbTimelineHeadline']/div[2]/div/a[4]")).click();
		
		List<WebElement> friends = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
		System.out.println("Total friends -> "+ friends.size());
		int newFriends = friends.size();// 20 40 60
		Actions act = new Actions(driver);

		int oldFriends = 0; // 0 20 40 60
		while(newFriends!=oldFriends){
			oldFriends = newFriends;
			WebElement lastFriend = friends.get(friends.size()-1);
			act.moveToElement(lastFriend).build().perform();// 20th
			Thread.sleep(3000);
			friends = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
			newFriends = friends.size();
			System.out.println("Total friends -> "+ friends.size());

		}
		
		System.out.println("FINAL Total friends -> "+ friends.size());
		for(int i=0;i<friends.size();i++){
			System.out.println(friends.get(i).getText());
		}

		

		


	}

}
