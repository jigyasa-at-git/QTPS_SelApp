import com.thoughtworks.selenium.DefaultSelenium;


public class RC_Example {
	
	public static void main(String arg[]){
		// opening timesofindia.com
		DefaultSelenium selenium = new DefaultSelenium("localhost"
				,4444,
				"*firefox",
				"http://timesofindia.com");
		
		selenium.start();
		selenium.open("/");
		selenium.setSpeed("3000");
		selenium.click("xpath=html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a");
		
		
		
		String text = selenium.getText("//*[@id='mathq2']");
		String temp[] =text.split(" "); // 2 + 3
		int n1 = Integer.parseInt(temp[0]);
		int n2 = Integer.parseInt(temp[2]);
		int sum=n1+n2;
		System.out.println("Sum is "+ sum);
		String s=String.valueOf(sum);
		selenium.type("//*[@id='mathuserans2']",s);
		
	
	
	}

}
