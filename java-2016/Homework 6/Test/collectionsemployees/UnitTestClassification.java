package collectionsemployees;



	import java.util.ArrayList;

	import org.junit.Test;

	public class UnitTestClassification {

		@Test
		public void inputListisEmpty()  {

			ArrayList<Employees> employeList = new ArrayList<Employees>();
			new Classification(employeList).classification();

		}

		@Test
		public void inputListContainsOtherQualification()  {

			ArrayList<Employees> employeList = new ArrayList<Employees>();

			employeList.add(new Employees("Razvan", true, 10, "Boss"));
			employeList.add(new Employees("Vlad", false, 20, "Developer"));
			employeList.add(new Employees("Mihai", false, 15, "Tester"));
			employeList.add(new Employees("Pit", true, 13, "Developer"));
			employeList.add(new Employees("Daniel", false, 5, "Support"));
			employeList.add(new Employees("Andrei", true, 16, "Tester"));
			employeList.add(new Employees("Aurel", false, 14, "Support"));

			new Classification(employeList).classification();

		}
	}

