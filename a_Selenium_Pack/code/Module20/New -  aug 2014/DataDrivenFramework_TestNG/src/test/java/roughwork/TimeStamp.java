package roughwork;

import java.util.Date;

public class TimeStamp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString().replace(":", "_"));
	}

}
