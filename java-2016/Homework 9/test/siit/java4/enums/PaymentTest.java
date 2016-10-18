package test.siit.java4.enums;


import org.junit.Test;

import enums.Employee;
import enums.ManagerException;
import enums.Payment;
import static org.junit.Assert.*;
import java.util.ArrayList;


	public class PaymentTest {

		@Test
		public void salesOfficerSalaryCheck() throws ManagerException {
			ArrayList<Employee> employees = new ArrayList<>();
			ArrayList<Employee> employees2 = new ArrayList<>();

			Employee e = new Employee ("Andrei", "Sales Manager", 80, 0, 0, 0, 10000);
			Employee e1 = new Employee ("Paul", "Sales Officer", 80, 0, 0, 0, 0);
			Employee e2 = new Employee ("Paul", "Sales Officer", 80, 0, 0, 0, 800);

			employees.add(e1);
			employees.add(e);
			employees2.add(e2);
			employees2.add(e);

			Payment p = new Payment();
			employees = p.paymentcalc(employees);

			assertEquals(employees, employees2);
		}
		
		@Test
		public void seniorSalesOfficerSalaryCheck() throws ManagerException {
			ArrayList<Employee> employees = new ArrayList<>();
			ArrayList<Employee> employees2 = new ArrayList<>();

			Employee e = new Employee("Andrei", "Sales Manager", 80, 0, 0, 0, 10000);
			Employee e1 = new Employee("Bogdan", "Senior Sales Officer", 80, 0, 0, 0, 0);
			Employee e2 = new Employee("Bogdan", "Senior Sales Officer", 80, 0, 0, 0, 1600);

			employees.add(e1);
			employees.add(e);
			employees2.add(e2);
			employees2.add(e);

			Payment p = new Payment();
			employees = p.paymentcalc(employees);

			assertEquals(employees, employees2);
		}
		
		@Test
		public void managerSalaryCheck() throws ManagerException {
			ArrayList<Employee> employees = new ArrayList<>();
			ArrayList<Employee> employees2 = new ArrayList<>();

			Employee e = new Employee("Andrei", "Sales Manager", 80, 0, 0, 0, 3500);
			Employee e1 = new Employee("Bogdan", "Senior Sales Officer", 80, 0, 10, 0, 0);
			Employee e2 = new Employee("Bogdan", "Senior Sales Officer", 80, 0, 10, 0, 1850);

			employees.add(e1);
			employees.add(e);
			employees2.add(e2);
			employees2.add(e);

			Payment p = new Payment();
			employees = p.paymentcalc(employees);

			assertEquals(employees, employees2);
		}
		
		@Test(expected = ManagerException.class)
		public void noManagerInList() throws ManagerException {
			ArrayList<Employee> employees = new ArrayList<>();
			ArrayList<Employee> employees2 = new ArrayList<>();

			Employee e1 = new Employee("Bogdan", "Senior Sales Officer", 80, 0, 10, 0, 0);
			Employee e2 = new Employee("Mircea", "Senior Sales Officer", 80, 0, 10, 0, 1850);

			employees.add(e1);
			employees2.add(e2);

			Payment p = new Payment();
			employees = p.paymentcalc(employees);

		}
		
	}
