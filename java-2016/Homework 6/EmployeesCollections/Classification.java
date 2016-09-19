/**
 * The class receives an ArrayList as input and creates separate ArrayList's 
 * based on the employee classification
 */

package collectionsemployees;

	import java.util.ArrayList;
	import java.util.List;

	public class Classification {

		ArrayList<Employees> EmployeList;
		List<Employees> Managers = new ArrayList<Employees>();
		List<Employees> Developers = new ArrayList<Employees>();
		List<Employees> Testers = new ArrayList<Employees>();
		List<Employees> Support = new ArrayList<Employees>();

		public Classification(ArrayList<Employees> employeList) {

			EmployeList = employeList;
		}

		public void classification() {
			for (Employees e : EmployeList) {

				switch (e.getRole()) {
				case "Manager":
					Managers.add(e);
					break;
				case "Developer":
					Developers.add(e);
					break;
				case "Tester":
					Testers.add(e);
					break;
				case "Support":
					Support.add(e);
					break;
				default:System.out.println("No employee with this job qualification");
				}

			}
			System.out.println("Managers:" + Managers);
			System.out.println("Developers:" + Developers);
			System.out.println("Testers:" + Testers);
			System.out.println("Support:" + Support);
		}
	}
