import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Date_Java {

	public static void main(String[] args) throws ParseException {
		    String d="14/10/2014";//dd//mm/yyyy
		    
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    Date date = formatter.parse(d);
			System.out.println(date);
			
		    String month=new SimpleDateFormat("MMM").format(date);
		    String date1=new SimpleDateFormat("dd").format(date);
		    String year=new SimpleDateFormat("yyyy").format(date);
		    System.out.println(month);
		    System.out.println(date1);
		    System.out.println(year);
		    
	}

}
