import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Login {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		String encodedPasswd="dGVtcEAxMjM0";
		driver.findElement(By.xpath("")).sendKeys(decodeStr(encodedPasswd));

	}
	
	public static String decodeStr(String encodedStr){
		byte[] decoded = Base64.decodeBase64(encodedStr);
		return new String(decoded);
	}

}
//*[@id='p_13838465-results']/li[1]/a
//*[@id='p_13833456-results']/li[1]/a
//*[@id='p_13833556-results']/li[1]/a


//*[@id='xyz9893893']
//*[@id='xyz2839029']
//*[@id='9823972389479']
//*[@id='xyzhaisdhjihdih']


//*[@id='xyz7263277abc']

//xpath functions


//http://automationtricks.blogspot.com/2010/09/how-to-use-functions-in-xpath-in.html

//button[starts-with(@id, 'continue-')] 
//input[starts-with(@id,'xyz')] 

//input[contains(@class, 'abc')]