package testcases;

import java.util.ArrayList;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class LaptopDisplayTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		String brand="HP"; // parameterize
		Selenium selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://www.flipcart.com");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		//selenium.setSpeed("2000");
		selenium.open("/");
		
		selenium.click("//*[@id='fk-header-tab-computer']/div[1]/a/div/div[1]/div");
		selenium.waitForPageToLoad("30000");
		selenium.click("//*[@id='fk-categories-list-id']/ul/li[2]/a");
		selenium.waitForPageToLoad("30000");
		selenium.select("//*[@id='brand']", "label="+brand);
		selenium.select("//*[@id='priceBand']", "label=Rs.25000 - Rs.35000");
		//*[@id='results-data']/div/div/div[1]/div/div[1]/div/a[2]
		//*[@id='results-data']/div/div/div[1]/div/div[2]/div/a[2]
		//*[@id='results-data']/div/div/div[1]/div/div[3]/div/a[2]
		String start="//*[@id='results-data']/div/div/div[1]/div/div[";
		String end="]/div/a[2]";
		Thread.sleep(2000L);
		//Below Rs.25000
		//Rs.25000 - Rs.35000
		//Rs.35000 - Rs.45000
		//Rs.45000 - Rs.60000
		//Above Rs.60000
		//*[@id='results-data']/div/div/div[1]/div/div[1]/div/div[2]/span
		//*[@id='results-data']/div/div/div[1]/div/div[2]/div/div[2]/span
		
		String start_price="//*[@id='results-data']/div/div/div[1]/div/div[";
		String end_price="]/div/div[2]/span";
		int index=1;
		
		while(selenium.isElementPresent(start+index+end)){
			// execute
			String text = selenium.getText(start+index+end);
			System.out.println(text);
			if(text.startsWith(brand)){
				System.out.println("Pass");
			}else{
				System.out.println("Fail");
			}
			
			String p=selenium.getText(start_price + index +end_price);
			System.out.println(p);
			String[] temp = p.split(" ");
			System.out.println(temp[1]); // price in string
			int price = Integer.parseInt(temp[1]);
			String currentValInDropList=selenium.getSelectedLabel("//*[@id='priceBand']");
			if(currentValInDropList.equals("Below Rs.25000") && price>25000){
				System.out.println("Fail");
			}else if(currentValInDropList.equals("Rs.25000 - Rs.35000") && (price<25000 || price>35000)){
				System.out.println("FAIL");
			}else if(currentValInDropList.equals("Rs.35000 - Rs.45000") && (price<35000 || price>45000)){
				System.out.println("FAIL");
			}else if(currentValInDropList.equals("Rs.45000 - Rs.60000") && (price<45000 || price>60000)){
				System.out.println("FAIL");
			}else if(currentValInDropList.equals("Above Rs.60000") && price>65000 ){
				System.out.println("FAIL");
			}else{
				System.out.println("PASS");
			}
			
			index++;
		}
		
		
		
		
		
		
		
		
		
		
	}

}
