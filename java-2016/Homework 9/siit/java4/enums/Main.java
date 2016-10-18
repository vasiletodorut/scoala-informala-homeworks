package siit.java4.enums;

import java.io.*;
import java.util.ArrayList;


	public class Main {

		public static void main(String[] args) throws ManagerException {

			String fileName = "src/siit/java4/enums/sales-team.txt";
			ArrayList<Employee> employees = new ArrayList<>();
			Payment paymentcalc = new Payment();
			Split rowSplit = new Split();

			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
				String currentLine;

				while ((currentLine = bufferedReader.readLine()) != null) {
					Employee p = rowSplit.fragmenter(currentLine);
					employees.add(p);
				}
				employees = paymentcalc.paymentcalc(employees);

				for (Employee p : employees) {
					System.out.println(p.name + " " + p.salary);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
