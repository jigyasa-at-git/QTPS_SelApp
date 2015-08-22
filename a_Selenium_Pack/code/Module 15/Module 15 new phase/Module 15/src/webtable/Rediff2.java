package webtable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rediff2 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		// 3rd col - //table[@class='dataTable']/tbody/tr/td[3]
		String part1="//table[@class='dataTable']/tbody/tr[";
		String part2="]/td[3]";
		//for(int rNum=1;rNum<)
		int i=1;
		while(isElementPresent(part1+i+part2)){
			String text = driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(text);
			i++;
			
			// click
			// http://www.espncricinfo.com
		}
		
		
		

	}
	public static boolean isElementPresent(String xpathEle){
		int size = driver.findElements(By.xpath(xpathEle)).size();
		
		if(size>0)
			return true;
		else
			return false;
		
	}

}
