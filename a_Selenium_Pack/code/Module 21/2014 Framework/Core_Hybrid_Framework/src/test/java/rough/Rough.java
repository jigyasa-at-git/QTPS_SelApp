package rough;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rough {

	public static void main(String[] args)  {
		/*
		WebDriver driver = new FirefoxDriver();
		driver.get("http://in.rediff.com");
		driver.findElement(By.xpath("//a[@id='xxxxxx']")).click();
		*/
		Date d = new Date();
		System.out.println(d.toString());
		String fileName=d.toString().replace(":", "-")+".xlsx";
		Workbook wb = new XSSFWorkbook();
	    FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("F:\\"+fileName);
			 wb.write(fileOut);
			    fileOut.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	   
	}

}
