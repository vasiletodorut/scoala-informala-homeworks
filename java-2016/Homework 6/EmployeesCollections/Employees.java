/**
 * In the class Employee is defined an employee by name, parking space , seniority and role 
 *  and provides the getters for them.
 */
package collectionsemployees;

public class Employees {

		String name;
		boolean parkingSpace;
		int seniority;
		String role;

		public Employees(String name, boolean parkingSpace, int seniority, String role) {

			this.name = name;
			this.parkingSpace = parkingSpace;
			this.seniority = seniority;
			this.role = role;
		}

		public String getName() {
			return name;
		}

		public boolean isParkingSpace() {
			return parkingSpace;
		}

		public int getSeniority() {
			return seniority;
		}

		public String getRole() {
			return role;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", parkingSpace=" + parkingSpace + ", seniority=" + seniority + ", role="
					+ role + "]";
		}

}
