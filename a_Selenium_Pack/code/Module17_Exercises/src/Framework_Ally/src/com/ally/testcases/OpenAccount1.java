package com.ally.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenAccount1 {

	
	@Test(dataProvider="getData")
	public void openAccount(
							String custType,
							String prodType,
							String acctType,
							String openingDeposit,
							String holders,
							String x,
							String y
							
							) throws InterruptedException{
		
		System.out.println(custType);
		System.out.println(prodType);
		System.out.println(acctType);
		System.out.println(openingDeposit);
		System.out.println(holders);
		
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.ally.com/");
		
		driver.findElement(By.xpath("//*[@id='global']/div[1]/ul/li[6]/h5/a")).click();//open account
		driver.findElement(By.xpath("//*[@id='article']/div[1]/div/div[2]/a")).click();//get started
		
		// get Started
		driver.findElements(By.xpath("//input[@name='applicationType']")).get(Integer.parseInt(custType)).click();
		driver.findElement(By.xpath("//*[@id='nextButton']")).click();

		//select a product
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElements(By.xpath("//input[@name='custCategory']")).get(0)));
		driver.findElements(By.xpath("//input[@name='custCategory']")).get(Integer.parseInt(prodType)).click();
		driver.findElement(By.xpath("//*[@id='blind2continue']")).click();
		driver.findElement(By.xpath("//*[@id='nonIRAdiv']/div/div/div[5]/div[1]/div[2]/div[2]/div/div[1]/a/span")).click();
		driver.findElement(By.xpath("//div[@id='cb_nonIraProductType']/div[@class='menu']/ul/li["+acctType+"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id='nonIraOpenAmountPvtEncrypt']")).sendKeys(openingDeposit);
		driver.findElement(By.xpath("//*[@id='nonIRAaddButt']")).click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='nonIraNextButton']"))));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='nonIraNextButton']")).click();
		
		// your info
		driver.findElements(By.xpath("//input[@name='ownerType']")).get(1).click();// joint
		driver.findElement(By.xpath("//*[@id='accOwner']/div[2]/div/div[1]/a")).click();
		
		driver.findElement(By.xpath("//div[@id='cb_titems']/div[@class='menu']/ul/li["+holders+"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id='blind3Continue']")).click();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Xls_Reader xls = new Xls_Reader("G://Ally.xlsx");
		int rows = xls.getRowCount("OpenAccount"); //2
		int cols = xls.getColumnCount("OpenAccount"); //5
		Object data[][] = new Object[rows-1][cols];//[1][5]
		
		
		for(int rNum=2;rNum<=rows;rNum++){
			for(int cNum=0;cNum<cols;cNum++){
				data[rNum-2][cNum] = xls.getCellData("OpenAccount", cNum, rNum);
			}
		}
		
		return data;
		
		
	}

}
