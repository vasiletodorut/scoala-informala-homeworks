package studentsexceptions;

	import static org.junit.Assert.assertEquals;
	import java.util.ArrayList;
	import java.util.TreeSet;
	import org.junit.Test;

import studentexceptions.LastNameComparator;
import studentexceptions.Repository;
import studentexceptions.Student;
import studentexceptions.Validation;
	
	public class UnitTestOperations {

		
		
		@Test(expected = Validation.class)
		public void addStudentWrongYear() throws Validation {

			Repository O = new Repository();
			O.addStudent(new Student("Timo", "Williams", 1885, "male", 187091937));
		}

		

		@Test(expected = Validation.class)
		public void addStudentIDNotGood() throws Validation {

			Repository O = new Repository();
			O.addStudent(new Student("Timo", "Williams", 1985, "male", 18709197));
		}

		@Test(expected = Validation.class)
		public void addStudentGenderNotGood() throws Validation {

			Repository O = new Repository();
			O.addStudent(new Student("Timo", "Williams", 1985, "abc", 187091937));
		}

		

		@Test(expected = Validation.class)
		public void deleteStudenWrongID() throws Validation {

			Repository O = new Repository();
			O.deleteStudentByID(1851014);
		}

		@Test(expected = Validation.class)
		public void deleteStudentDifferentID() throws Validation {

			Repository O = new Repository();
			O.addStudent(new Student("Timo", "Williams", 1985, "male", 187091937));
			O.addStudent(new Student("Robby", "Mark", 1982, "Male", 183020824));

			O.deleteStudentByID(1851014);
		}

		
		@Test(expected = Validation.class)
		public void retrieveStudentAgeNotGood() throws Validation {

			Repository O = new Repository();
			O.addStudent(new Student("Timo", "Williams", 1985, "male", 187091937));
			O.addStudent(new Student("Robby", "Mark", 1982, "Male", 183020824));

			O.retreiveStudents(-10);
		}

		@Test(expected = Validation.class)
		public void retrieveStudentWrongAgeInput() throws Validation {

			Repository O = new Repository();
			O.addStudent(new Student("Timo", "Williams", 1985, "male", 187091937));
			O.addStudent(new Student("Robby", "Mark", 1982, "Male", 183020824));

			O.retreiveStudents(28);
		}

		
		@Test
		public void studentsOrderedByLastName() throws Validation {
			TreeSet<Student> list = new TreeSet<Student>(new LastNameComparator());
			list.add(new Student("Timo", "Williams", 1985, "male", 187091937));
			list.add(new Student("Robby", "Mark", 1982, "Male", 183020824));

			Repository O = new Repository();
			O.addStudent(new Student("Timo", "Williams", 1985, "male", 187091937));
			O.addStudent(new Student("Robby", "Mark", 1982, "Male", 183020824));

			assertEquals(list, O.orderStudentsByLastName());
		}

		@Test(expected = Validation.class)
		public void studentOrderByLastNameEmptyList() throws Validation {

			Repository O = new Repository();
			O.orderStudentsByLastName();
		}
	}
