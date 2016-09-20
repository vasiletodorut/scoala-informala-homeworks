package collectionsemployees;


	import java.util.ArrayList;
	import org.junit.Test;

	public class IntegrationCompanyTest {

		@Test
		public void processIsWorking(){

			ArrayList<Employees> employeList = new ArrayList<Employees>();

			employeList.add(new Employees("Ionut", false, 8, "Developer"));
			employeList.add(new Employees("Paul", true, 16, "Manager"));
			employeList.add(new Employees("Bogdan", false, 12, "Support"));
			employeList.add(new Employees("Alex", true, 13, "Developer"));
			employeList.add(new Employees("Dan", false, 17, "Tester"));
			employeList.add(new Employees("Alex", true, 2, "Tester"));
			employeList.add(new Employees("George", false, 7, "Developer"));

			new Classification(employeList).classification();
			System.out.println(
					"___________________________________________________________");
			new CompanySystem(employeList).operation();
		}
	}
