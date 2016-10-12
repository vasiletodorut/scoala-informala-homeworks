package siit.java4.genericssort;

import java.util.Comparator;

public class BrandComparator implements Comparator<CarBrand> {

	
	@Override
	public int compare(CarBrand o1, CarBrand o2) {
		
		return o1.brand.compareTo(o2.brand);
	}
}