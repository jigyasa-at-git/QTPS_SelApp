import java.util.ArrayList;
import java.util.Hashtable;


public class CollectionAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int x[] = new int[5];
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("USA");  //0
		list.add("UK");//1
		list.add("Australia");//2
		//list.add(1000);
		
		System.out.println(list.size());
		
		for(int i =0; i<list.size() ; i++){
			System.out.println(list.get(i));
		}
		
		// key - value
		// key - unique
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("name", "John");
		table.put("place", "tokyo");
		table.put("name", "Stewart");
		
		System.out.println(table.get("name"));
		
		
		
	}

}
