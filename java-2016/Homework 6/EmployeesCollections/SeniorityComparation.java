/**
 *  This class compares the seniority of the employees from list and sorts them by seniority   
 */

package collectionsemployees;

import java.util.Comparator;

	public class SeniorityComparation implements Comparator<Employees> {

		@Override
		public int compare(Employees e1, Employees e2) {
			if (e1.getSeniority() > e2.getSeniority()) {
				return 1;
			}	else{
			}
			return 0;
		}
	}

		