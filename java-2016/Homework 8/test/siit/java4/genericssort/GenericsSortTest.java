package test.siit.java4.genericssort;

import org.junit.Test;
import static org.junit.Assert.*;
import siit.java4.genericssort.BubbleSortAlgorithm;
import siit.java4.genericssort.CarBrand;

public class GenericsSortTest {

	@Test
	public void stringSort() {
		String[] testList = new String[] { "Audi", "Ford", "Opel", "Seat", "Volkswagen" };

		BubbleSortAlgorithm sortAlg = new BubbleSortAlgorithm();
		String[] brands = new String[] { "Opel", "Volkswagen", "Audi", "Seat", "Ford" };
		String[] sortedNames = sortAlg.sortPrimitives(brands);

		assertArrayEquals(testList, brands);
	}

	@Test
	public void objectSort() {
		CarBrand[] testBrands = new CarBrand[] { new CarBrand("Audi", 1910), new CarBrand("Opel", 1863),
				new CarBrand("Seat", 1950), new CarBrand("Volkswagen", 1937) };

		BubbleSortAlgorithm sortAlg = new BubbleSortAlgorithm();
		CarBrand[] brands = new CarBrand[] { new CarBrand("Opel", 1863), new CarBrand("Volkswagen", 1937),
				new CarBrand("Audi", 1910), new CarBrand("Seat", 1950) };
		CarBrand[] sortedPersoane = sortAlg.sortObjects(brands, CarBrand.BRAND_COMP);

		assertArrayEquals(testBrands, brands);

	}

	@Test
	public void numberSort() {
		Integer[] testList = new Integer[] { -1, 0, 1, 2, 6, 15, 24, 27, 34, 45, 50, 80, 1910, 1937, 1950 };

		BubbleSortAlgorithm sortAlg = new BubbleSortAlgorithm();
		Integer[] numbers = new Integer[] { 1950, 50, 24, 6, 1937, 2, 0, 1, 15, 34, 1910, 27, 45, 80, -1 };
		Integer[] sortedNumbers = sortAlg.sortPrimitives(numbers);

		assertArrayEquals(testList, sortedNumbers);

	}
}
