import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class JavascriptAlerts {

	
	public static void main(String[] args) {
		Selenium selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://in.rediff.com");
		selenium.start();
		selenium.setSpeed("2000");
		selenium.open("/");
		selenium.click("link=Sign in");
		selenium.click("btn_login");
		
		if(selenium.isAlertPresent()){
			System.out.println(selenium.getAlert()); // get the text
			selenium.chooseOkOnNextConfirmation();  //ok  
			//selenium.chooseCancelOnNextConfirmation(); //   cancel
			
		}
		System.out.println(selenium.isAlertPresent()); // false
		

		
	}

}
