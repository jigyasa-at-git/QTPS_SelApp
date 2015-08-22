package com.qtpselenium.suite.shop;

import java.util.Random;

import org.testng.SkipException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qtpselenium.util.TestUtil;

public class RandomSelection extends TestSuiteBase{
	String runmodes[]=null;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	static int count=-1;
	// Runmode of test case in a suite
		@BeforeTest
		public void checkTestSkip(){
			
			if(!TestUtil.isTestCaseRunnable(suite_shop_xls,this.getClass().getSimpleName())){
				APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
				throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
			}
			runmodes=TestUtil.getDataSetRunmodes(suite_shop_xls, this.getClass().getSimpleName());
		}
		
		@Test
		public void testSelection() throws InterruptedException{
			System.out.println("************");
			
			//WebDriver driver = new FirefoxDriver();
			
			openBrowser();
			driver.get(CONFIG.getProperty("testSiteName"));
			driver.findElement(By.xpath(OR.getProperty("shopLink"))).click();
			driver.findElement(By.xpath(OR.getProperty("mp3_player_link"))).click();
			//random
			compareTitle("MP3 Player");
			
			String first=OR.getProperty("part1");
			String second=OR.getProperty("part2");
			String third=OR.getProperty("part3");
			int row=3;
			boolean end=false;
			int totalElements=0;
			while(true){
				
				for(int col=1;col<=4;col++){
					try{
					String text = driver.findElement(By.xpath(first+row+second+col+third)).getText();
					System.out.println(text);
					totalElements++;
				    }catch(Exception e){
				    	// no element left
				    	end=true;
				    	break; // for
				    }
				}
				if(end)
					break;
				row=row+2;
				
			}
			System.out.println("Total Element -- "+totalElements );
			// generate random number between 1 to totalElements
			Random item_num = new Random();
			int random_number = item_num.nextInt(totalElements);
			if(random_number ==0)
				random_number=item_num.nextInt(totalElements);
			System.out.println(random_number);
			
			// Task
			
			
			
			/*	
			
			String clickedElement_text =driver.findElement(By.xpath("//*[@id='vmMainPage']/div[1]/div[5]/div[1]/div/h2/a")).getText();
			driver.findElement(By.xpath("//*[@id='vmMainPage']/div[1]/div[5]/div[1]/div/h2/a")).click();
			String displayElement_text=driver.findElement(By.xpath("//*[@id='vmMainPage']/div[1]/div[4]/h1")).getText();
			
			System.out.println(clickedElement_text);
			System.out.println(displayElement_text);

			*/
			
			 row=3;
			 end=false;
			 totalElements=0;
			 String clicked_link_name=null;
			while(true){
				
				for(int col=1;col<=4;col++){
					try{
					if(totalElements == random_number){
						clicked_link_name=driver.findElement(By.xpath(first+row+second+col+third)).getText();
						driver.findElement(By.xpath(first+row+second+col+third)).click();
						end=true;
						break;
					}
					
					totalElements++;
				    }catch(Exception e){
				    	// no element left
				    	end=true;
				    	break; // for
				    }
				}
				if(end)
					break;
				row=row+2;
				
			}
			
			// next page
			String display_name=driver.findElement(By.xpath("//*[@id='vmMainPage']/div[1]/div[4]/h1")).getText();
			System.out.println(display_name);
			System.out.println(clicked_link_name);
			Assert.assertEquals(display_name, clicked_link_name);
			Thread.sleep(5000L);
			closeBrowser();
			
		}
		
		@AfterMethod
		public void reportDataSetResult(){
			if(skip)
				TestUtil.reportDataSetResult(suite_shop_xls, this.getClass().getSimpleName(), count+2, "SKIP");
			else if(fail){
				isTestPass=false;
				TestUtil.reportDataSetResult(suite_shop_xls, this.getClass().getSimpleName(), count+2, "FAIL");
			}
			else
				TestUtil.reportDataSetResult(suite_shop_xls, this.getClass().getSimpleName(), count+2, "PASS");
			
			skip=false;
			fail=false;
			

		}
		
		@AfterTest
		public void reportTestResult(){
			if(isTestPass)
				TestUtil.reportDataSetResult(suite_shop_xls, "Test Cases", TestUtil.getRowNum(suite_shop_xls,this.getClass().getSimpleName()), "PASS");
			else
				TestUtil.reportDataSetResult(suite_shop_xls, "Test Cases", TestUtil.getRowNum(suite_shop_xls,this.getClass().getSimpleName()), "FAIL");
		
		}
		
		
		
		

		
		
		
		
		
	
}
