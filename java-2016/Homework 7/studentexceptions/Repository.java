/*
 * The class receives lists as input and throw exceptions in case the date of birth, name, ID or gender 
 * are not correctly
 */

package studentexceptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;

public class Repository {

	public ArrayList<Student> students = new ArrayList<Student>();
	public TreeSet<Student> studentsOrderByLastName = new TreeSet<Student>(new LastNameComparator());
	public ArrayList<Student> toRemove = new ArrayList<Student>();
	public ArrayList<Student> studentsRetrievedByAge = new ArrayList<Student>();

	public void addStudent(Student s) throws Validation {

		int length = (int) (Math.log10(s.getID()) + 1);
		int year = Calendar.getInstance().get(Calendar.YEAR);

		if ((s.getDateOfBirth() < 1900) || (s.getDateOfBirth() > year - 18)) {
			throw new Validation ("The year is not good");
		}
		if ((s.getFirstName() == null) || (s.getLastName() == null) || (s.getLastName() == "")
				|| (s.getFirstName() == "")) {
			throw new Validation ("The name is not complete");
		}
		if (length != 9) {
			throw new Validation ("The ID is not good");
		}
		if ((s.getGender().equalsIgnoreCase("male")) || (s.getGender().equalsIgnoreCase("female"))
				|| (s.getGender().equalsIgnoreCase("M")) || (s.getGender().equalsIgnoreCase("F"))) {
			students.add(s);
		} else {
			throw new Validation ("Gender is not good");

		}

	}

	public void deleteStudentByID(int ID) throws Validation {

		int length = (int) (Math.log10(ID) + 1);
		boolean studentController = false;

		if ((ID == 0) || (length != 13)) {
			throw new Validation ("The ID provided is not good");
		} else {
			for (Student s : students) {
				if (s.getID() == ID) {
					toRemove.add(s);
					studentController = true;
				}
			}
			if (studentController == false) {
				throw new Validation ("Student with this ID does not exist");
			} else {
				students.removeAll(toRemove);
			}
		}

	}

	public ArrayList<Student> retreiveStudents(int age) throws Validation {
		boolean ageController = false;
		int year = Calendar.getInstance().get(Calendar.YEAR);

		if ((age < 0) || (age != (int) age)) {
			throw new Validation("Age is not good");
		} else {
			for (Student s : students) {
				if (year - s.getDateOfBirth() == age) {
					ageController = true;
					studentsRetrievedByAge.add(s);
				}
			}
			if (ageController == false) {
				throw new Validation("No person with this age exists");
			}

		}
		return studentsRetrievedByAge;
	}


	public TreeSet<Student> orderStudentsByLastName() throws Validation {
		if (students.isEmpty()) {
			throw new Validation("Input is empty");
		} else {
			for (Student s : students) {
				studentsOrderByLastName.add(s);
			}
		}
		return studentsOrderByLastName;
	}
}