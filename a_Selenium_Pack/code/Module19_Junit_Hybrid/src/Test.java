import reports.ReportUtil;
import util.TestUtil;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
		
		ReportUtil.startTesting("C://myreports//index.html", TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), "PROD", "3.4.55");
		
		ReportUtil.startSuite("Suite 1");
		// 1st test
		ReportUtil.addKeyword("Navigate to the test site", "navigate", "Pass", null);
		ReportUtil.addKeyword("xxxxxxxxx", "yyyyyy", "Pass", null);
		ReportUtil.addKeyword("hhhhhhhh", "uuuuuuuu", "Pass", null);
		ReportUtil.addKeyword("wwwwwwwwww", "qqqqqqqqqqq", "Pass", null);
		ReportUtil.addTestCase("Header Test", "11:00AM", "11:30 PM", "Pass");
		
		ReportUtil.addKeyword("Navigate to the test site", "navigate", "Pass", null);
		ReportUtil.addKeyword("xxxxxxxxx12", "yyyyyy", "Pass", null);
		ReportUtil.addKeyword("hhhhhhhh", "uuuuuuuu", "Pass", null);
		ReportUtil.addKeyword("wwwwwwwwww", "qqqqqqqqqqq", "Pass", null);
		ReportUtil.addTestCase("Header Test", "11:00AM", "11:30 PM", "Pass");
		
		// 2nd test
		ReportUtil.addKeyword("Navigate to the test site", "navigate", "Pass", null);
		ReportUtil.addKeyword("xxxxxxxxx", "yyyyyy", "Pass", null);
		ReportUtil.addKeyword("hhhhhhhh", "uuuuuuuu", "Fail - err msg", null);
		ReportUtil.addKeyword("wwwwwwwwww", "qqqqqqqqqqq", "Pass", null);
		ReportUtil.addTestCase("Login Test", "11:00AM", "11:30 PM", "Fail");
		ReportUtil.endSuite();
		
		ReportUtil.startSuite("Suite 2");
		ReportUtil.addTestCase("Register Test", "11:00AM", "11:30 PM", "Skip");
		ReportUtil.endSuite();
		
		ReportUtil.updateEndTime(TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));

		
	}

}
