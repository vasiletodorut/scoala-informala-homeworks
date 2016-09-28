package studentsexceptions;

import org.junit.Test;

import studentexceptions.Repository;
import studentexceptions.Student;
import studentexceptions.Validation; 

public class IntegrationTestStudent {

	@Test
	public void processIsWorking() throws Validation {

		try {
			Repository O = new Repository();

			O.addStudent(new Student("Abby", "Abraham", 1883, "Female", 284022945));
			O.addStudent(new Student("Timo", "Williams", 1985, "male", 187091937));
			O.addStudent(new Student("Mackenzie", "Djokovici", 1987, "M", 290101426));
			O.addStudent(new Student("Mackenzie", "Djokovici", 1987, "M", 290101426));
			O.addStudent(new Student("Madison", "Conner", 1989, "Female", 285051014));
			O.addStudent(new Student("Robby", "Mark", 1982, "Male", 183020824));

			O.orderStudentsByLastName();
			O.deleteStudentByID(285051014);
			System.out.println("___");
		} catch (Validation e) {
			System.out.println(e.getMessage());
		}
	}
}
