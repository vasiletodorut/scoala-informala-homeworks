package enums;

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

			for (Employee p : employees) {

				if (p.jobposition.equals("Senior Sales Officer")) {
					p.salary = seniorsalesofficepayment(p.workedhours, p.daysoff, 
					p.prepaidsales,p.postpaidsales);
					
					totalpostpaidsales += p.postpaidsales;
					totalprepaidsales += p.prepaidsales;
				}
				if (p.jobposition.equals("Sales Officer")) {
					p.salary = salesOfficeSalaryCalculator(p.workedhours, p.daysoff,
							p.prepaidsales,	p.postpaidsales);
					
					totalpostpaidsales += p.postpaidsales;
					totalprepaidsales += p.prepaidsales;
				}
			}

			for (Employee p : employees) {
				if (p.jobposition.equals("Sales Manager")) {
					p.salary = managerSalaryCalculator(p.workedhours, p.daysoff,
							totalprepaidsales,totalpostpaidsales);
					multiplemanagercheck++;
				}
			}

			if (multiplemanagercheck != 1) {
				throw new ManagerException("No or too many managers in the list");
			}
			return employees;
		}

		/**
		 * Manager salary calculator.
		 *
		 * @param managerHoursWorked
		 *            the manager hours worked
		 * @param managerNrOfDaysOff
		 *            the manager nr of days off
		 * @param totalPrepaidSales
		 *            the total prepaid sales
		 * @param totalPostpaidSales
		 *            the total postpaid sales
		 * @return the int
		 */
		public int managerSalaryCalculator(int workedhours, int daysoff, 
				int totalprepaidsales, int totalpostpaidsales) {
			int salary = 0;
			salary = Bonus.managersalary.value * workedhours+ Bonus.managersalary.value * 8 * daysoff
					+ Bonus.managerpostpaidbonus.value * totalpostpaidsales
					+ Bonus.managerprepaidbonus.value * totalprepaidsales;

			return salary;
		}

		/**
		 * Senior sales office salary calculator.
		 *
		 * @param workedHours
		 *            the worked hours
		 * @param daysOff
		 *            the days off
		 * @param prepaidSales
		 *            the prepaid sales
		 * @param postpaidSales
		 *            the postpaid sales
		 * @return the int
		 */
		public int seniorsalesofficepayment (int workedhours, int daysoff, 
				int prepaidsales, int postpaidsales) {
			int salary = 0;
			salary = Bonus.seniorsalesofficersalary.value * workedhours
					+ Bonus.seniorsalesofficersalary.value * 8 * daysoff
					+ Bonus.seniorsalesofficerprepaidbonus.value * prepaidsales
					+ Bonus.seniorsalesofficerpostpaidbonus.value * postpaidsales;

			return salary;
		}

		/**
		 * Sales office salary calculator.
		 *
		 * @param workedHours
		 *            the worked hours
		 * @param daysOff
		 *            the days off
		 * @param prepaidSales
		 *            the prepaid sales
		 * @param postpaidSales
		 *            the postpaid sales
		 * @return the int
		 */
		public int salesOfficeSalaryCalculator(int workedhours, int daysoff, int prepaidsales, int postpaidsales) {
			int salary = 0;
			salary = Bonus.seniorofficersalary.value * workedhours + Bonus.seniorofficersalary.value * 8 * daysoff
					+ Bonus.seniorofficerprepaidbonus.value * prepaidsales
					+ Bonus.seniorofficerpostpaidbonus.value * postpaidsales;

			return salary;
		}

}
