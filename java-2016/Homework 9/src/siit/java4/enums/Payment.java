/**
 * The salaries are calculated from an enum input and by type of job position
 */


package siit.java4.enums;

import java.util.ArrayList;

	
	public class Payment {

		
		public enum Bonus {

			
	managersalary(40),
	seniorsalesofficersalary(20),
	seniorofficersalary(10),
			
	managerpostpaidbonus(30),
	seniorsalesofficerpostpaidbonus(50), 
	seniorofficerpostpaidbonus(25),
	
	managerprepaidbonus(15),
	seniorsalesofficerprepaidbonus(25),
	seniorofficerprepaidbonus(10);

			
			int value;

			
			private Bonus(int value) {
				this.value = value;
			}
		}

		
		public ArrayList<Employee> paymentcalc(ArrayList<Employee> employees) throws ManagerException {
			int multiplemanagercheck = 0;
			int totalpostpaidsales = 0;
			int totalprepaidsales = 0;

			for (Employee e : employees) {

				if (e.jobposition.equals("Senior Sales Officer")) {
					e.salary = seniorsalesofficepayment(e.workedhours, e.daysoff, 
					e.prepaidsales,e.postpaidsales);
					
					totalpostpaidsales += e.postpaidsales;
					totalprepaidsales += e.prepaidsales;
				}
				if (e.jobposition.equals("Sales Officer")) {
					e.salary = salesOfficeSalaryCalculator(e.workedhours, e.daysoff,
							e.prepaidsales,	e.postpaidsales);
					
					totalpostpaidsales += e.postpaidsales;
					totalprepaidsales += e.prepaidsales;
				}
			}

			for (Employee e : employees) {
				if (e.jobposition.equals("Sales Manager")) {
					e.salary = managerSalaryCalculator(e.workedhours, e.daysoff,
							totalprepaidsales,totalpostpaidsales);
					multiplemanagercheck++;
				}
			}

			if (multiplemanagercheck != 1) {
				throw new ManagerException("No or too many managers in the list");
			}
			return employees;
		}

	
		public int managerSalaryCalculator(int workedhours, int daysoff, 
				int totalprepaidsales, int totalpostpaidsales) {
			int salary = 0;
			salary = Bonus.managersalary.value * workedhours+ Bonus.managersalary.value * 8 * daysoff
					+ Bonus.managerpostpaidbonus.value * totalpostpaidsales
					+ Bonus.managerprepaidbonus.value * totalprepaidsales;

			return salary;
		}

	
		public int seniorsalesofficepayment (int workedhours, int daysoff, 
				int prepaidsales, int postpaidsales) {
			int salary = 0;
			salary = Bonus.seniorsalesofficersalary.value * workedhours
					+ Bonus.seniorsalesofficersalary.value * 8 * daysoff
					+ Bonus.seniorsalesofficerprepaidbonus.value * prepaidsales
					+ Bonus.seniorsalesofficerpostpaidbonus.value * postpaidsales;

			return salary;
		}

		public int salesOfficeSalaryCalculator(int workedhours, int daysoff, int prepaidsales, int postpaidsales) {
			int salary = 0;
			salary = Bonus.seniorofficersalary.value * workedhours + Bonus.seniorofficersalary.value * 8 * daysoff
					+ Bonus.seniorofficerprepaidbonus.value * prepaidsales
					+ Bonus.seniorofficerpostpaidbonus.value * postpaidsales;

			return salary;
		}

}
