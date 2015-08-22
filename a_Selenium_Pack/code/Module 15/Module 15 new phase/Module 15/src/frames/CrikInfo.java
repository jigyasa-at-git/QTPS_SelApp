package frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import autosuggests.Google;

public class CrikInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	driver.get("http://www.espncricinfo.com/ci/engine/match/scores/live.html");
	
	//driver.switchTo().frame(0);
	//driver.findElement(By.xpath("html/body/div[1]/div[1]/p[1]/span/a")).click();
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println("Total frames - "+size);
	/*
	for(int i=0;i<size;i++){
		driver.switchTo().frame(i);
		int total = driver.findElements(By.xpath("html/body/div[1]/div[1]/p[1]/span/a")).size();
		System.out.println(total);
		driver.switchTo().defaultContent();
	}
	*/
	driver.switchTo().frame(2);
	driver.findElement(By.xpath("html/body/div[1]/div[1]/p[1]/span/a")).click();	

	}

}
