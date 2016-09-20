package collectionsemployees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTestSeniorityComparation {

	@Test
	public void seniorityIsProcesedWithNegativeValue() {
		Employees first = new Employees("Ionut", false, -4, "Developer");
		Employees second = new Employees("Paul", true, 16, "Manager");
		SeniorityComparation expect = new SeniorityComparation();
		int expected = expect.compare(first, second);

	}

	@Test
	public void seniorityIsProcesedWithFirstPersonOlder() {
		Employees first = new Employees("Ionut", true, 23, "Developer");
		Employees second = new Employees("Paul", false, 15, "Manager");
		SeniorityComparation expect = new SeniorityComparation();
		int expected = expect.compare(first, second);

		assertEquals(1, expected);
	}
}
