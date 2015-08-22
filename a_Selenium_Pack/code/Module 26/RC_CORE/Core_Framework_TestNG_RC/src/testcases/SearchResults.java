package testcases;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SearchResults {

	
	public static void main(String[] args) {

		String searchString="Obama"; // parameterized
		
		Selenium selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://www.flipcart.com");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		selenium.setSpeed("2000");
		selenium.open("/");
		selenium.click("//*[@id='fk-mS']");
		selenium.click("//*[@id='fk-mI']/ul/li[2]/div"); // clicking on books
		selenium.type("//*[@id='fk-top-search-box']", searchString);
		selenium.click("//*[@id='fk-header-search-form']/table/tbody/tr/td[4]/div/input");
		selenium.waitForPageToLoad("30000");
		
		String start="//*[@id='search_results']/div[";
		String end="]/div[2]";
		
		for(int i=3;i<=5;i++){
			
			System.out.println(selenium.getText(start+i+end));
			String text = selenium.getText(start+i+end).toLowerCase();
			if(text.indexOf(searchString.toLowerCase()) == -1){
				System.out.println("**Fail**");
			}else{
				System.out.println("**PASS**");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
