import datatable.Xls_Reader;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String testCase="RegistrationTest";
		Xls_Reader datatable = new Xls_Reader(System.getProperty("user.dir")+"//src//config//Suite1.xlsx");
		System.out.println(datatable.getRowCount("Test Cases"));
		System.out.println(datatable.getCellData("Test Cases", "TCID", 3));
		
		for(int rowNum=2 ; rowNum<=datatable.getRowCount("Test Cases");rowNum++){
			if(testCase.equals(datatable.getCellData("Test Cases", "TCID", rowNum))){
				if(datatable.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))
					System.out.println("run the test");
				else
					System.out.println("skip test");
			}
		}
		
		

	}

}
