package frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames_In_Frames {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total frames in page- "+size);
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("html/body/p[1]")).getText());
		
		size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total frames in frame A - "+size);
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("html/body/h1")).getText());
		driver.switchTo().defaultContent(); // main page

		

	}

}
