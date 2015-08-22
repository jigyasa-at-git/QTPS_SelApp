import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class Html_Droplist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
	    Selenium selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://www.ebay.com");
		selenium.start();
		selenium.open("/");
		selenium.windowMaximize();
		selenium.windowFocus();
		selenium.setSpeed("2000");
		System.out.println(selenium.getSelectedLabel("//*[@id='_sacat']"));

		selenium.select("//*[@id='_sacat']", "label=Books");
		System.out.println(selenium.getSelectedLabel("//*[@id='_sacat']"));

		String allVals[] = selenium.getSelectOptions("//*[@id='_sacat']");
		
		for (int i=0;i<allVals.length;i++){
			System.out.println(allVals[i]);
		}
		selenium.captureEntirePageScreenshotToString("C:\\temp.jpg");
		// select a random value
		//System.out.println(Math.random());
		double i=Math.random()*100;
		System.out.println(i);
		int x = (int)i;
		System.out.println(x);
		
		
		
		
		
		
		
		
	}

}
