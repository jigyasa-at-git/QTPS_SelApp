import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WeBuy {

	@Test
	public void testProductPurchaseProcess(){
		
		Xls_Reader xls = new Xls_Reader("F:\\xlfiles\\WeBuy.xlsx");
		int rows = xls.getRowCount("Products");
		System.out.println("Total rows in xls -> " + rows);
		List<String> productsNamesToBeAdded = new ArrayList<String>();
		Hashtable<String,String> productQuatityToBeAdded = new Hashtable<String,String>();
		for(int i=2;i<=rows;i++){
			String productName = xls.getCellData("Products", "ProductName", i);
			String productQuantity = xls.getCellData("Products", "Quantity", i);
			
			System.out.println(productName +" --- "+productQuantity);
			productsNamesToBeAdded.add(productName);
			productQuatityToBeAdded.put(productName,productQuantity);
		}
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://uk.webuy.com/search/index.php?stext=*&section=&catid=956");
		List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='searchRecord']/div[2]/h1/a"));
		List<WebElement> allButtons = driver.findElements(By.xpath("//div[@class='action']/div/a[2]"));
		
		System.out.println("Total names = "+ allNames.size());
		System.out.println("Total buttons = "+ allButtons.size());
		int prodCount=0;
		for(int i=0;i< allNames.size();i++){
			if(productsNamesToBeAdded.contains(allNames.get(i).getText())){
				System.out.println("FOUND --- " +allNames.get(i).getText());
				allButtons.get(i).click();
				// validate basket count
				String count = driver.findElement(By.id("buyBasketCount")).getText();
				System.out.println("Basket count - "+ count);
				Assert.assertEquals(count, String.valueOf(prodCount+1));
				 allNames = driver.findElements(By.xpath("//div[@class='searchRecord']/div[2]/h1/a"));
				 allButtons = driver.findElements(By.xpath("//div[@class='action']/div/a[2]"));
				 prodCount++;
			}
			
		}
		// change the quantities
		driver.findElement(By.linkText("View basket")).click();
		List<WebElement> selects =driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[1]/div/select"));
		System.out.println("Total select Boxes - "+ selects.size());
		List<WebElement> secondCol =driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[2]"));
		
		for(int i=0;i<secondCol.size()-2;i++){
			String key=secondCol.get(i).getText().split("\\n")[0];
			System.out.println(key +" ---- " +productQuatityToBeAdded.get(key));
			WebElement dropDown = selects.get(i);
			Select s  = new Select(dropDown);
			s.selectByVisibleText(productQuatityToBeAdded.get(key));
			
			 secondCol =driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[2]"));
			 selects =driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[1]/div/select"));
		}
		
		double sum =0.0; // 4.0 //8.5
		List<WebElement> fourthCol =driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr/td[4]"));
		for(int i=0;i<fourthCol.size();i++){
			String value = fourthCol.get(i).getText().split("\\£")[1];
			System.out.println(value);
			sum = sum + Double.parseDouble(value);
		}
		System.out.println("Total cost for prods - "+sum);
		
		// total rows
		int totalRows = driver.findElements(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr")).size();
		String delCharges = driver.findElement(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr["+(totalRows-1)+"]/td[2]")).getText();
		String expectedVal=driver.findElement(By.xpath("//div[@class='basketPageBox']/form/table/tbody/tr["+(totalRows)+"]/td[2]")).getText();
		System.out.println("Delivery charges - "+ delCharges);
		double charges = Double.parseDouble(delCharges.split("\\£")[1]);
		double actualTotal= sum + charges;
		double expectedTotal = Double.parseDouble(expectedVal.split("\\£")[1]);
		System.out.println("Actual Total - "+ actualTotal);

		System.out.println("Expected Total - "+ expectedTotal);
		Assert.assertEquals(actualTotal, expectedTotal);
		
	}
}
