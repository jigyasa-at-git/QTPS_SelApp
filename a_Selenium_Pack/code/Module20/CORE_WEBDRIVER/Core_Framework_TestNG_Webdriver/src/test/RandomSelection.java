package test;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RandomSelection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.virtuemart.net/");
		
		driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[1]/div/ul/li[2]/a/span")).click();
		driver.findElement(By.xpath("//*[@id='vmMainPage']/div[2]/div[1]/div[1]/div/h2/a/img")).click();
		//random
		
		String first="//*[@id='vmMainPage']/div[1]/div[";
		String second="]/div[";
		String third="]/div/h2/a";
		int row=3;
		boolean end=false;
		int totalElements=0;
		while(true){
			
			for(int col=1;col<=4;col++){
				try{
				String text = driver.findElement(By.xpath(first+row+second+col+third)).getText();
				System.out.println(text);
				totalElements++;
			    }catch(Exception e){
			    	// no element left
			    	end=true;
			    	break; // for
			    }
			}
			if(end)
				break;
			row=row+2;
			
		}
		System.out.println("Total Element -- "+totalElements );
		// generate random number between 1 to totalElements
		Random item_num = new Random();
		int random_number = item_num.nextInt(totalElements);
		if(random_number ==0)
			random_number=item_num.nextInt(totalElements);
		System.out.println(random_number);
		
		// Task
		
		
		
		/*	
		
		String clickedElement_text =driver.findElement(By.xpath("//*[@id='vmMainPage']/div[1]/div[5]/div[1]/div/h2/a")).getText();
		driver.findElement(By.xpath("//*[@id='vmMainPage']/div[1]/div[5]/div[1]/div/h2/a")).click();
		String displayElement_text=driver.findElement(By.xpath("//*[@id='vmMainPage']/div[1]/div[4]/h1")).getText();
		
		System.out.println(clickedElement_text);
		System.out.println(displayElement_text);

		*/
		
		 row=3;
		 end=false;
		 totalElements=0;
		while(true){
			
			for(int col=1;col<=4;col++){
				try{
				if(totalElements == random_number){	
					driver.findElement(By.xpath(first+row+second+col+third)).click();
					end=true;
					break;
				}
				
				totalElements++;
			    }catch(Exception e){
			    	// no element left
			    	end=true;
			    	break; // for
			    }
			}
			if(end)
				break;
			row=row+2;
			
		}
		
		
		
		
	}

}
