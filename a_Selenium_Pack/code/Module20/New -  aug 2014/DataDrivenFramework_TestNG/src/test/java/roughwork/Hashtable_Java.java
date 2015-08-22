package roughwork;

import java.util.Hashtable;

public class Hashtable_Java {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Hashtable<String,String> table= new Hashtable<String,String> ();
		table.put("place", "Korea");
		table.put("continent", "asia");
		System.out.println(table.get("place"));

	}

}
