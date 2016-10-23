package enums;

public class Employee {
		
		
		String name;
		String jobposition;
		int workedhours;
		int daysoff;
		int prepaidsales;
		int postpaidsales;
		int salary;

	
		public Employee(String name, String jobposition, int workedhours, int daysoff, 
				int prepaidsales, int postpaidsales, int salary) {

			this.name = name;
			this.jobposition = jobposition;
			this.workedhours = workedhours;
			this.daysoff = daysoff;
			this.prepaidsales = prepaidsales;
			this.postpaidsales = postpaidsales;
			this.salary = salary;
		}

		
		@Override
		public String toString() {
			return "Person [name=" + name + ", jobposition=" + jobposition + ","
					+ " workedhours=" + workedhours + ","
					+ " daysoff=" + daysoff + ", "+ "prepaidsales=" + prepaidsales + ","
					+ " paidsales="	+ postpaidsales + ", salary=" + salary + "]";
		}

		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + daysoff;
			result = prime * result + workedhours;
			result = prime * result + postpaidsales;
			result = prime * result + prepaidsales;
			result = prime * result + ((jobposition == null) ? 0 : jobposition.hashCode());
			result = prime * result + salary;
			return result;
		}

		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (daysoff != other.daysoff)
				return false;
			if (workedhours != other.workedhours)
				return false;
			if (postpaidsales != other.postpaidsales)
				return false;
			if (prepaidsales != other.prepaidsales)
				return false;
			if (jobposition == null) {
				if (other.jobposition != null)
					return false;
			} else if (!jobposition.equals(other.jobposition))
				return false;
			if (salary != other.salary)
				return false;
			return true;
	}
}
