package profilesuite;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class ProfileTest {
	WebDriver driver = null;
	String portfolioName="Portfolio600";
	String newPortfolioName="Portfolio601";
	@Test(priority=1)
	public void createProfileTest() {
		
		String browser="Mozilla";
		
		if(browser.equals("Mozilla")){
			driver=new FirefoxDriver();
		}else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\Whizdom-Trainings\\Tools\\Selenium\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
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
		// creating Portfolio

		clickAndWait("//*[@id='createPortfolio']", "//*[@id='create']");
		//driver.findElement(By.xpath("//*[@id='createPortfolio']")).click();
		
		
		driver.findElement(By.xpath("//*[@id='create']")).clear();
		driver.findElement(By.xpath("//*[@id='create']")).sendKeys(portfolioName);
		driver.findElement(By.xpath("//*[@id='createPortfolioButton']")).click();
		
		boolean result=isElementPresent("//select[@id='portfolioid']/option[text()='"+portfolioName+"']",5);
		Assert.assertTrue(result,"Portfolio name not present in list");
		
		WebElement dropDown=driver.findElement(By.xpath("//*[@id='portfolioid']"));
		Select dropList = new Select(dropDown);
		System.out.println(dropList.getFirstSelectedOption().getText());
		
		Assert.assertEquals(dropList.getFirstSelectedOption().getText(), portfolioName);
		
		
		String stockText = driver.findElement(By.xpath("//table[@id='stock']/tbody")).getText().trim();
		Assert.assertEquals(stockText, "");
		
		String mfText = driver.findElement(By.xpath("//table[@id='mf']/tbody")).getText().trim();
		Assert.assertEquals(mfText, "");
		
		
	}
	
	@Test(priority=2,dependsOnMethods={"createProfileTest"})
	public void renameProfileTest(){
		//select the portfolio name which you need to rename
		driver.findElement(By.xpath("//*[@id='portfolioid']")).sendKeys(portfolioName);
		driver.findElement(By.xpath("//*[@id='portfolioid']")).sendKeys(Keys.ENTER);
		
		clickAndWait("//*[@id='renamePortfolio']", "//*[@id='rename']");
		
		
		//driver.findElement(By.xpath("//*[@id='renamePortfolio']")).click();
		// Renaming
		driver.findElement(By.xpath("//*[@id='rename']")).clear();
		driver.findElement(By.xpath("//*[@id='rename']")).sendKeys(newPortfolioName);
		driver.findElement(By.xpath("//*[@id='renamePortfolioButton']")).click();
		
		boolean result=isElementPresent("//select[@id='portfolioid']/option[text()='"+newPortfolioName+"']",5);
		Assert.assertTrue(result,"Portfolio name not present in list");
		
		WebElement dropDown=driver.findElement(By.xpath("//*[@id='portfolioid']"));
		Select dropList = new Select(dropDown);
		System.out.println(dropList.getFirstSelectedOption().getText());
		
	}
	
	@Test(priority=3,dependsOnMethods={"createProfileTest","renameProfileTest"})
	public void deleteProfileTest() throws InterruptedException{
		System.out.println("deleteProfileTest***");
		// profile selected
		driver.findElement(By.xpath("//*[@id='portfolioid']")).sendKeys(newPortfolioName);
		driver.findElement(By.xpath("//*[@id='portfolioid']")).sendKeys(Keys.ENTER);
		
		//driver.findElement(By.xpath("//*[@id='deletePortfolio']")).click();

		
		clickAndWaitTillAlert("//*[@id='deletePortfolio']").accept();
		
		
		
		
	//	WebElement dropDown=driver.findElement(By.xpath("//*[@id='portfolioid']"));
		//Select dropList = new Select(dropDown);
		//System.out.println(dropList.getFirstSelectedOption().getText());
		
	}
	
	
	
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	public boolean isElementPresent(String xpathXpr, int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		int s = driver.findElements(By.xpath(xpathXpr)).size();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		if(s>0)
			return true;
		else
			return false;
		
	}
	
	public boolean isElementPresent(String xpathXpr){
		int s = driver.findElements(By.xpath(xpathXpr)).size();
		
		if(s>0)
			return true;
		else
			return false;
		
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
			
	
	
	public void clickAndWait(String elementToBeClicked, String elementToBeVisible){
		// will click 5 times  - 1 every 3 seconds
		System.out.println("*****************************");
		for(int i=0;i<5;i++){
			System.out.println("Clicking");
			driver.findElement(By.xpath(elementToBeClicked)).click();
			if(isElementPresent(elementToBeVisible) && driver.findElement(By.xpath(elementToBeVisible)).isDisplayed()){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				return;
			}else{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
