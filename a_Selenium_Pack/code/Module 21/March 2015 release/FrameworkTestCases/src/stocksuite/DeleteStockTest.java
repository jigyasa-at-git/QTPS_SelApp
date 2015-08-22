package stocksuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DeleteStockTest {
	
	WebDriver driver = null;
	String portfolioName="Portfolio118";
	String companyName="Tata Motors Ltd.";
	
	
	@Test
	public void addPortfolioNewStockTest() throws InterruptedException{
String browser="Chrome";
		
		if(browser.equals("Mozilla")){
			driver=new FirefoxDriver();
		}else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\Whizdom-Trainings\\Tools\\Selenium\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Navigate and login
		driver.get("http://in.rediff.com/");
		driver.findElement(By.xpath("//*[@id='homewrapper']/div[5]/a[3]/div/u")).click();
		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("ashishthakur1983");

		if(browser.equals("Chrome")){
			while(!driver.findElement(By.xpath("//*[@id='userpass']")).isDisplayed()){
				driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys(Keys.ENTER);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys(Keys.ENTER);
		}

		driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys("pass@1234");
		driver.findElement(By.xpath("//*[@id='loginsubmit']")).click();
		
		// select portfolio 
		driver.findElement(By.xpath("//*[@id='portfolioid']")).sendKeys(portfolioName);
		driver.findElement(By.xpath("//*[@id='portfolioid']")).sendKeys(Keys.ENTER);
		//select stock
		int rowNum = getTableRowNumWithCompanyName(companyName);
		driver.findElement(By.xpath("//table[@id='stock']/tbody/tr["+rowNum+"]/td[1]/input")).click();
		clickAndWaitTillAlert("//*[@id='deleteEquity']").accept();
		rowNum = getTableRowNumWithCompanyName(companyName);
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text='"+companyName+"']")));

		
		
	}
	
	public int getTableRowNumWithCompanyName(String companyName){
		int rowNum=-1;
		//parse the table
		List<WebElement> names = driver.findElements(By.xpath("//table[@id='stock']/tbody/tr/td[2]"));
		List<WebElement> quantities =driver.findElements(By.xpath("//table[@id='stock']/tbody/tr/td[3]"));
		List<WebElement> prices =driver.findElements(By.xpath("//table[@id='stock']/tbody/tr/td[4]"));
	//validate the table
		for(int rNum=0;rNum<names.size();rNum++){
		System.out.println(names.get(rNum).getText()+" --- "+quantities.get(rNum).getText()+" ---- "+prices.get(rNum).getText());
			if(names.get(rNum).getText().equals(companyName)){
				rowNum=rNum+1;
			}else if(rNum == names.size()-1){
				return rowNum;
			}
		
	    }
		
		return rowNum;
		
	}
	

	public Alert clickAndWaitTillAlert(String elementToBeClicked){
		// will click 5 times  - 1 every 3 seconds
		Alert al = null;
		for(int i=0;i<5;i++){
			driver.findElement(By.xpath(elementToBeClicked)).click();
			try{
				al = driver.switchTo().alert();
				return al;
			}catch(Exception e){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return al;
	}
	

	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.close();	
	}

}
