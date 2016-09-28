package studentexceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	
	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String args[]) {

		LOGGER.fine("In main");

		LOGGER.info("start main");

		try {
			Repository sr = new Repository();

			LOGGER.fine("before reading the students");
			sr.addStudent(new Student("Abby", "Abraham", 1883, "Female", 284022945));
			sr.addStudent(new Student("Timo", "Williams", 1985, "male", 187091937));
			sr.addStudent(new Student("Mackenzie", "Djokovici", 1987, "M", 290101426));
			sr.addStudent(new Student("Madison", "Conner", 1989, "Female", 285051014));
			sr.addStudent(new Student("Robby", "Mark", 1982, "Male", 183020824));
			
			LOGGER.fine("after reading the students");

			LOGGER.fine("before sorting the students by LastName");
			System.out.println(sr.orderStudentsByLastName());
			LOGGER.fine("after sorting the students by LastName");

			LOGGER.fine("before deleting a student");
			sr.deleteStudentByID(2821014);
			LOGGER.fine("after deleting a student");

			System.out.println("|______");

			LOGGER.fine("before retrieving a student");
			System.out.println(sr.retreiveStudents(24));
			LOGGER.fine("after retrieving a student");

		} catch (Validation e) {
			System.out.println(e.getMessage());
			LOGGER.log(Level.SEVERE, "Error with inputs", e);
			e.printStackTrace();
		}
		LOGGER.info("end main");
	}
}