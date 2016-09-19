/**
 * The CompanySystem class receives an ArrayList and creates a TreeSet list with the employees 
 * that don't have a parking space based on their seniority
 */

package collectionsemployees;

import java.util.ArrayList;
import java.util.TreeSet;

	public class CompanySystem {

		ArrayList<Employees> EmployeList;
		TreeSet<Employees> list = new TreeSet<Employees>(new SeniorityComparation());

		public CompanySystem(ArrayList<Employees> employeList) {

			EmployeList = employeList;
		}

		public TreeSet<Employees> operation() {
			for (Employees e : EmployeList) {
				if (e.isParkingSpace() == false) {
					list.add(e);
				}
			}

			for (Employees en : list) {
				System.out.println(en);
			}
				return list;
		}
	}
