
public class TestEmployee {

	public static void main(String[] args) {

		Employee e1 = new Employee();
		//int x = 9;
		e1.name="Sam";
		e1.companyName="GM";
		e1.salary=99999;
		e1.doInduction();
		e1.promote();
		e1.removeEmployee();
		
		System.out.println("*******************");
		
		Employee e2 = new Employee();
		e2.name="Tina";
		e2.companyName="GM";
		e2.salary=88898;
		e2.doInduction();
		e2.promote();
		e2.removeEmployee();
		
		e1.companyName="Walmart";
		System.out.println(e1.companyName);
		System.out.println(e2.companyName);
		Employee.companyName="xyz"; // static var
		//Employee.name="abc";
		
		Employee.giveSalaryOnMonthend();


	}

}
