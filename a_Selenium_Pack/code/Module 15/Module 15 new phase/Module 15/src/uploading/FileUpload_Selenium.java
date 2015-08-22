package uploading;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload_Selenium {

	/**
	
	$windowHandle = WinGetHandle("File Upload")
        WinActivate($windowHandle)

		ControlSetText("File Upload", "", "[CLASS:Edit; INSTANCE:1]", $CmdLine[1])
	    ControlClick("File Upload", "","[CLASS:Button; INSTANCE:1]")
	
	
	 */
	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://qtpselenium.com/test/uploadform/contactform.php");
		
		//driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("F:\\ashish.jpg");
		
		// AUTO - IT
		driver.findElement(By.xpath("//input[@id='photo']")).click();
		


		 Process process = new ProcessBuilder(System.getProperty("user.dir")+"\\src\\uploading\\temp.exe",
			                "F:\\ashish.jpg", "Open").start();

	}

}
