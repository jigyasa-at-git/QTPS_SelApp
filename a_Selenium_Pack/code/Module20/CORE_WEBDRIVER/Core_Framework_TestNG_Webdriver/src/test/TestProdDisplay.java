package test;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestProdDisplay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.virtuemart.net/");
		driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[1]/div/ul/li[2]/a/span")).click();
		// wait
		
		WebElement featured_view = driver.findElement(By.className("featured-view"));
		
		int no_of_imgs= featured_view.findElements(By.tagName("img")).size();
		int no_of_show_links = featured_view.findElements(By.linkText("Show")).size();
		System.out.println("Total images are -- " + no_of_imgs);
		System.out.println("Total show links are -- " + no_of_show_links);

		
		
		
		
		
		
		
		
		                              
		
		
		
		
		
		
	}

}
