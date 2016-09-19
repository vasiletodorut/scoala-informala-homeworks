/**
 * The company class has an array list which contains employees
 */


package collectionsemployees;

import java.util.ArrayList;

	public class Company {

		public static void main(String[] args) {

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
			"_______________________________________________________________________");
			new CompanySystem(employeList).operation();
		}
	}
