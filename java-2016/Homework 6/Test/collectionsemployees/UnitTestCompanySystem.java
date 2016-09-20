package collectionsemployees;



	import static org.junit.Assert.assertEquals;
	import java.util.ArrayList;
	import java.util.TreeSet;
	import org.junit.Test;

	public class UnitTestCompanySystem {

		@Test
		public void listIsCorrectDisplayed() {

			ArrayList<Employees> employeList = new ArrayList<Employees>();
			TreeSet<Employees> list = new TreeSet<Employees>(new SeniorityComparation());

			employeList.add(new Employees("Ionut", false, 8, "Developer"));
			employeList.add(new Employees("Paul", true, 16, "Manager"));
			employeList.add(new Employees("Bogdan", false, 12, "Support"));
			employeList.add(new Employees("Alex", true, 13, "Developer"));
			employeList.add(new Employees("Dan", false, 17, "Tester"));
			employeList.add(new Employees("Alex", true, 2, "Tester"));
			employeList.add(new Employees("George", false, 7, "Developer"));

			TreeSet<Employees> test1 = new CompanySystem(employeList).operation();

			employeList.add(new Employees("Ionut", false, 8, "Developer"));
			employeList.add(new Employees("Bogdan", false, 12, "Support"));
			employeList.add(new Employees("Dan", false, 17, "Tester"));
			employeList.add(new Employees("George", false, 7, "Developer"));

					}

		@Test
		public void inputListisEmpty() {

			ArrayList<Employees> employeList = new ArrayList<Employees>();
			TreeSet<Employees> list = new TreeSet<Employees>(new SeniorityComparation());

			new CompanySystem(employeList).operation();

			list.add(new Employees("Ionut", false, 8, "Developer"));
			list.add(new Employees("Bogdan", false, 12, "Support"));
			list.add(new Employees("Dan", false, 17, "Tester"));
			list.add(new Employees("George", false, 7, "Developer"));

		}
}
