import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class FindingElementsAndText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		Selenium selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://www.bbc.com");
		selenium.start();
		selenium.setSpeed("2000");
		selenium.open("/");
		
		if(selenium.isElementPresent("//*[@id='news_moreTopStories']/ul/li[2]/a")){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		
		if(selenium.isTextPresent("Libya have been putting")){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		
		
	}

}
