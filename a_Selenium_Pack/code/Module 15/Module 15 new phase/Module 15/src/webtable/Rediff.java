package webtable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rediff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		// rows  //table[@class='dataTable']/tbody/tr
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("Total rows - "+ rows.size());
		/*
		for(int i=0;i<rows.size();i++){
			System.out.println(rows.get(i).getText());
		}
		*/
		
		// cols //table[@class='dataTable']/tbody/tr[3]/td
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[3]/td"));
		System.out.println("Total cols - "+ cols.size());

		// 20th row - //table[@class='dataTable']/tbody/tr[20]
		// 1st col - //table[@class='dataTable']/tbody/tr/td[1]
		
		
		String companyName="Bata India";
		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		
		for(int i=0;i<companyNames.size();i++){
			
			if(companyNames.get(i).getText().equals(companyName)){
			  System.out.println(companyNames.get(i).getText() +" --- "+ currentPrices.get(i).getText());
			  // click on the company link
			  WebElement cell = companyNames.get(i);
			  //cell.findElement(By.tagName("a")).click();
			  cell.findElements(By.tagName("a")).get(0).click();
			  break;
			}
		}
		
		
		/*
		List<WebElement> completeList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td"));
		
		for(int i=0;i<completeList.size();i++){
			System.out.println(completeList.get(i).getText());
		}
		*/
		
		
		
	}

}
