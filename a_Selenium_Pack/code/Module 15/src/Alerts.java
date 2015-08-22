import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Alerts {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://in.rediff.com");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("//*[@id='btn_login']")).click();
		Thread.sleep(5000);
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();//OK
		//al.dismiss();//cancel
		// switch to regular page
		driver.switchTo().defaultContent();
		// normal commands
	}

}
