package stocksuite;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;









import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddPortFolioNewStockTest {
	WebDriver driver = null;
	String portfolioName="test";
	String companyName="Tata Motors Ltd.";
	String date="24/04/2014";
	String quantity="100";
	String price="10";
	
	@Test
	public void addPortfolioNewStockTest(){
String browser="Mozilla";
		
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
		/**********Login over***********/
		
		// select portfolio and then click on add stock button
		driver.findElement(By.xpath("//*[@id='portfolioid']")).sendKeys(portfolioName);
		driver.findElement(By.xpath("//*[@id='portfolioid']")).sendKeys(Keys.ENTER);

		clickAndWait("//*[@id='addStock']", "//*[@id='stockPurchaseDate']");
	
		// select the company name char by char
		selectAjaxCompanyName("//*[@id='addstockname']",companyName);
		
		// select the date. 
		// 1) Get the date objects
		// 2) Get the month and year for date to be selected
		driver.findElement(By.xpath("//*[@id='stockPurchaseDate']")).click();//click on date icon
		
		Date currentDate = new Date();// get current date
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToBeSelected =null;
		try {
			 dateToBeSelected = formatter.parse(date); // date object of the date to be selected
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String month=new SimpleDateFormat("MMMM").format(dateToBeSelected);		
		String day=new SimpleDateFormat("dd").format(dateToBeSelected);		
		String year=new SimpleDateFormat("yyyy").format(dateToBeSelected);		
	    String month_yearExpected = month+" "+year;
	    
		while(true){
			
			String month_yearDisplayed = driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[3]/div")).getText();
			if(month_yearDisplayed.equals(month_yearExpected))
				break; // correct month
			
			if(currentDate.after(dateToBeSelected))
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
			else
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
				
		}
		// fill company details
		driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
		
		driver.findElement(By.xpath("//*[@id='addstockqty']")).sendKeys(quantity);
		driver.findElement(By.xpath("//*[@id='addstockprice']")).sendKeys(price);
		driver.findElement(By.xpath("//*[@id='addStockButton']")).click();		
		// wait for new list to be to be loaded
		Assert.assertTrue(isElementPresent("//a[text()='"+companyName+"']",10),"Stock not added");
		//parse the table
			List<WebElement> names = driver.findElements(By.xpath("//table[@id='stock']/tbody/tr/td[2]"));
			List<WebElement> quantities =driver.findElements(By.xpath("//table[@id='stock']/tbody/tr/td[3]"));
			List<WebElement> prices =driver.findElements(By.xpath("//table[@id='stock']/tbody/tr/td[4]"));
		//validate the table
			for(int rNum=0;rNum<names.size();rNum++){
			System.out.println(names.get(rNum).getText()+" --- "+quantities.get(rNum).getText()+" ---- "+prices.get(rNum).getText());
				if(names.get(rNum).getText().equals(companyName)){
					Assert.assertEquals(quantities.get(rNum).getText(), quantity);
					Assert.assertEquals(prices.get(rNum).getText(), price);
					break;
				}else if(rNum == names.size()-1){
					Assert.fail("Could not file the company in list- "+companyName);
				}
			
		}
		
	}
	// Tata Motors Ltd.
	public void selectAjaxCompanyName(String xpathExpr, String companyName2) {
		for(int i=0;i<companyName2.length();i++){
			char character=companyName2.charAt(i);
			driver.findElement(By.xpath(xpathExpr)).sendKeys(String.valueOf(character));
			if(isElementPresent("//div[@id='ajax_listOfOptions']/div[text()='"+companyName2+"']")){
				driver.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[text()='"+companyName2+"']")).click();
				break;
			}
		}
		
	}

	public void clickAndWait(String elementToBeClicked, String elementToBeVisible){
		// will click 5 times  - 1 every 3 seconds
		System.out.println("*****************************");
		for(int i=0;i<5;i++){
			System.out.println("Clicking");
			driver.findElement(By.xpath(elementToBeClicked)).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isElementPresent(elementToBeVisible) && driver.findElement(By.xpath(elementToBeVisible)).isDisplayed()){
				return;
			}				
			
			
		}
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

	
	public String getText(String identifier){
		String  text= driver.findElement(By.xpath(identifier)).getText();
		
		
		return text;
		
	}
}
