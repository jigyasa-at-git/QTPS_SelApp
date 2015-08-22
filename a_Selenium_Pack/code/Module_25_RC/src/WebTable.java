import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class WebTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Selenium selenium = new DefaultSelenium("localhost",4444,
				"*firefox","http://www.timeanddate.com");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
		//selenium.setSpeed("2000");
		selenium.open("/worldclock/");
		// ROWS
		int i=2;
		int totalRows=1;
		String xpath_start="xpath=//html/body/table[1]/tbody/tr[";
		String xpath_end="]/td[1]";
		
		while(selenium.isElementPresent(xpath_start+i+xpath_end)){
			i++;
			totalRows++;
		}
		
		System.out.println("Total rows -- " +totalRows);
		
		// COLUMNS
		i=1;
		int totalCols=0;
		String xpath_start1="xpath=//html/body/table[1]/tbody/tr[2]/td[";
		String xpath_end1="]";
		
		while(selenium.isElementPresent(xpath_start1+i+xpath_end1)){
			i++;
			totalCols++;
		}
		
		System.out.println("Total cols -- " +totalCols);
		
		// each  cell value
		String xpath_st="xpath=//html/body/table[1]/tbody/tr[";
		String xpath_mid="]/td[";
		String xpath_en="]";
		
		for(int rowNum=2 ; rowNum<=totalRows ; rowNum++){
			
			for(int colNum=1;colNum<=totalCols;colNum++){
				if(selenium.isElementPresent(xpath_st+rowNum+xpath_mid+colNum+xpath_en))
				//System.out.print(selenium.getText(xpath_st+rowNum+xpath_mid+colNum+xpath_en)+" - ");
					System.out.print(selenium.getTable("xpath=html/body/table[1]."+(rowNum-1)+"."+(colNum-1)) +" - ");
			}
			
			System.out.println();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
