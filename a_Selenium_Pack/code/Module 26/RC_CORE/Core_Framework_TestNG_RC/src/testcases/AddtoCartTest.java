package testcases;

import java.util.Random;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class AddtoCartTest {

	/**
	 * @param args
	 */
	static Selenium selenium ;
	public static void main(String[] args) throws InterruptedException {

		
		String brand="HP"; // parameterize
		 selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://www.flipcart.com");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		//selenium.setSpeed("2000");
		// books
		selectRandomItem("//*[@id='fk-header-tab-book']/div[1]/a/div/div[1]/div",
				"//*[@id='fk-mainbody-id']/div/div/div[3]/div[2]/div/div[",
				"]/div/div[2]/div/div[",
				"]/div/a[2]",
				2, 1);
		
		selenium.click("//*[@id='mprod-buy-btn']/input"); // add to cart
	    Thread.sleep(3000L); // correct this
		// computers
		selectRandomItem("//*[@id='fk-header-tab-computer']/div[1]/a/div/div[1]/div",
				"//*[@id='fk-mainbody-id']/div/div/div[3]/div[2]/div[3]/div[",
				"]/div/div[2]/div/div[",
				"]/div/a[2]",
				1, 1);
		selenium.click("//*[@id='mprod-buy-btn']/input"); // add to cart

	    Thread.sleep(3000L);
	    
	    
	    /**************NEW TEST CASE - CART******************/
	    selenium.open("/");
	    selenium.click("//*[@id='fk-mainhead-id']/div[1]/div/div[4]/div[3]/div/div/div");
	    Thread.sleep(3000L);
	    
	    String start="//*[@id='dotted-border']/tbody/tr[";
	    String end="]/td[5]";
	    int c=2;
	    int sum=0;
	    while(selenium.isElementPresent(start+c+end)){
	    	String price_text=selenium.getText(start+c+end);
	    	System.out.println(price_text);
	    	c++;
	    	String temp[] =price_text.split(" ");
	    	System.out.println(temp[1]);
	    	int price = Integer.parseInt(temp[1]);
	    	sum=sum+price;
	    }
	    System.out.println("Expected Total = "+sum);
		System.out.println("Actual Total = "+selenium.getText("//*[@id='panelsh']/div[2]/div[1]/div[3]/div/table/tbody/tr[2]/td[2]"));
		
	}
	
	public static void selectRandomItem(String productline,// xpath for product
			String start,// starting part
			String mid, //middle part
			String end, // end part
			int cat, // category ID
			int item){ // item id
		
		selenium.open("/");
		selenium.click(productline);
		selenium.waitForPageToLoad("30000");
		
		// find total books
		// random number < total number of books
		// select the book which has ID corres to randum number
		//String start="//*[@id='fk-mainbody-id']/div/div/div[3]/div[2]/div/div[";
		//String mid="]/div/div[2]/div/div[";
		//String end="]/div/a[2]";
		int total_items=0;
		
		int category=cat;
		int item_id=item;
		System.out.println("*************ALL ITEMS************************");
		while(selenium.isElementPresent(start+category+mid+item_id+end)){
			while(selenium.isElementPresent(start+category+mid+item_id+end)){
			   // System.out.println(selenium.getText(start+category+mid+item_id+end));
				item_id++;
				total_items++;
			}
			category++;
			item_id=1;
		}
		
		System.out.println("Total Items are -- "+total_items );
		
		
		
		// Generate random number
		Random number = new Random();
		int n = number.nextInt(24);
		
		if(n==0)
			n= number.nextInt(24);
		
		System.out.println("Randomly generated number is -- "+ n);
		
		
		// Select the book
		System.out.println("**************SELECTING BOOK********************");
		category=cat;
		item_id=item;
		int index=1;
		boolean found=false;
		
		while(selenium.isElementPresent(start+category+mid+item_id+end)){
			while(selenium.isElementPresent(start+category+mid+item_id+end)){
				String item_name=selenium.getText(start+category+mid+item_id+end);
			   // System.out.println(item_name);
			    if(index == n){
			    	// found the book
			    	selenium.click(start+category+mid+item_id+end);
			    	selenium.waitForPageToLoad("30000");
			    	found=true;
			    	break;
			    }
			    	
			    if(found)
			    	break;
			    
				item_id++;
				index++;
			}
			category++;
			item_id=1;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
