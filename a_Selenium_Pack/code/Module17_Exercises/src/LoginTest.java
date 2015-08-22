import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest {
	static String CaseAErr="The email or password you entered is incorrect. ?";
	static String CaseBErr="Enter your email address.";
	static String CaseCErr="Enter your password.";
	
	
	WebDriver driver ;
	/*
	@BeforeTest
	public void start(){
		driver = new FirefoxDriver();
	}
	
*/
	@Test(dataProvider="getData")
	public void doLogin(String browser,String username,String password,String expectedResult){
		
		
		if(browser.equals("Firefox"))
			driver = new FirefoxDriver();
		else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://gmail.com");
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(Keys.ENTER);
		
		String errMsg = driver.findElement(By.xpath("//span[@class='error-msg']")).getText();
		System.out.println(errMsg);
		
		// validations
		if(expectedResult.equals("CaseA"))
			Assert.assertEquals(errMsg, CaseAErr);
		else if(expectedResult.equals("CaseB"))
			Assert.assertEquals(errMsg, CaseBErr);
		else if(expectedResult.equals("CaseC"))
			Assert.assertEquals(errMsg, CaseCErr);
		
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		Xls_Reader xls = new Xls_Reader("F:\\xlfiles\\Login.xlsx");
		int rows = xls.getRowCount("Login");
		int cols = xls.getColumnCount("Login");
		
		Object data[][] = new Object[rows-1][cols];
		
		for(int rNum=2;rNum<=rows;rNum++){
			for(int cNum=0;cNum<cols;cNum++){
				System.out.println(xls.getCellData("Login", cNum, rNum));
				data[rNum-2][cNum] = xls.getCellData("Login", cNum, rNum);
				
				// 2 0  [0][0]
				// 2 1  [0][1]
				// 3 0  [1][0]
				// 3 1  [1][1]
			}
		}
		
		/*
		data[0][0]="U1";
		data[0][1]="P1";
		
		data[1][0]="U2";
		data[1][1]="P2";
		*/
		return data;
		
	}

}
