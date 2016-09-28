/*
 * This class compares the last name of the students from list.
 */
package studentexceptions;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getLastName().compareTo(s2.getLastName());
	}
}
