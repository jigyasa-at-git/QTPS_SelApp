import java.text.SimpleDateFormat;
import java.util.Date;


public class Rough {

	public static void main(String[] args) {
		Date currentDate = new Date(); //cuurent
		System.out.println(currentDate);
		
		String date="24/04/2014";// string date
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToBeSelected =null;
		try {
			 dateToBeSelected = formatter.parse(date); // date object of the date to be selected
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dateToBeSelected.after(currentDate));
		
		String month=new SimpleDateFormat("MMMM").format(dateToBeSelected);		
		System.out.println(month);
		
		String day=new SimpleDateFormat("dd").format(dateToBeSelected);		
		System.out.println(day);
		
		String year=new SimpleDateFormat("yyyy").format(dateToBeSelected);		
		System.out.println(year);


	}

}
