//www.sejsoft.com/downloads/jars.rar
public class Reading_Writing_XLS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Xls_Reader d = new Xls_Reader("C:\\Example.xlsx");
		System.out.println(d.getRowCount("Data"));
		System.out.println(d.getCellData("Data", "Place", 3));
		
		d.setCellData("Data", "Name", 10, "hello");
		
		
		//Xls_Reader d1 = new Xls_Reader("PATH");

	}

}
