/*
 * In this class are created getters and setters to add values for objects
 */

package siit.java4.genericssort;

import java.util.Comparator;

public class CarBrand {

	public static final Comparator<CarBrand> BRAND_COMP = new Comparator<CarBrand>() {

		@Override
		public int compare(CarBrand o1, CarBrand o2) {
			return o1.brand.compareTo(o2.brand);
		}
	};

	String brand;
	int yearofproduction;
	
	
	public CarBrand(String brand, int yearofproduction) {
		this.yearofproduction = yearofproduction;
		this.brand = brand;
	}

		
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYearOfProduction() {
		return yearofproduction;
	}

	
	public void setYearOfProduction(int yearofproduction) {
		this.yearofproduction = yearofproduction;
	}
	

	@Override
	public String toString() {
		return  brand + " - " + yearofproduction + " ; " ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + yearofproduction;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
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
		CarBrand other = (CarBrand) obj;
		if (yearofproduction != other.yearofproduction)
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		return true;
	}	

}