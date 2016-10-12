package siit.java4.genericssort;

import java.util.Arrays;

public class Main {

	
public static void main(String[] args) {
		
		BubbleSortAlgorithm sortAlg = new BubbleSortAlgorithm();

		CarBrand[] brand= new CarBrand[] {new CarBrand("Opel", 1863),new CarBrand("Volkswagen", 1937),
				new CarBrand("Audi", 1910), new CarBrand("Seat", 1950) };
		CarBrand[] brandsSorted = sortAlg.sortObjects(brand, CarBrand.BRAND_COMP);
		System.out.println(Arrays.toString(brandsSorted));
		
		Integer[] numbers = new Integer[] { 1950,50, 24, 6, 1937,2, 0, 1, 15, 34, 1910,27, 45, 80, -1 };
		Integer[] numbersSorted = sortAlg.sortPrimitives(numbers);
		System.out.println(Arrays.toString(numbersSorted));

		String[] brands = new String[] { "Opel", "Volkswagen", "Audi", "Seat", "Ford"};
		String[] sortedBrands = sortAlg.sortPrimitives(brands);
		System.out.println(Arrays.toString(sortedBrands));
		
		

	}

}

