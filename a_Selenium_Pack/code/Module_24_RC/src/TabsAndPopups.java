import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class TabsAndPopups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Selenium selenium = new DefaultSelenium("localhost",4444,
					"*firefox","http://www.hdfc.com");
			selenium.start();
			selenium.windowMaximize();
			selenium.windowFocus();
			selenium.setSpeed("2000");
			selenium.open("/");
			String windowNames[] = selenium.getAllWindowNames();
			System.out.println("***********Window NAMES before Opening tab");
			
			for(int i =0; i<windowNames.length ;i++){
				System.out.println(windowNames[i]);
			}

			selenium.click("//*[@id='acc-1-section-2']/li[2]/a");
			
			windowNames = selenium.getAllWindowNames();
			System.out.println("*************Window NAMES after Opening tab");
			for(int i =0; i<windowNames.length ;i++){
				System.out.println(windowNames[i]);
			}
			selenium.waitForPopUp(windowNames[1], "30000");
			selenium.selectWindow(windowNames[1]);
			selenium.click("xpath=//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/p[2]/a");
			
			windowNames = selenium.getAllWindowNames();
			System.out.println("*************Window NAMES after Opening POP UP");
			for(int i =0; i<windowNames.length ;i++){
				System.out.println(windowNames[i]);
			}
			
			selenium.waitForPopUp(windowNames[2], "30000");
			selenium.selectWindow(windowNames[2]);
			
			selenium.click("//*[@id='popup']/table/tbody/tr/td/table[2]/tbody/tr/td/table[1]/tbody/tr[4]/td/p/font/b/a");
			selenium.select("//*[@id='selState']", "label=GOA");
			
			selenium.close();
			selenium.selectWindow(windowNames[1]);
			selenium.close();
			selenium.selectWindow(windowNames[0]);
			selenium.close();
			selenium.stop();

			
			
			
			
	}

}
