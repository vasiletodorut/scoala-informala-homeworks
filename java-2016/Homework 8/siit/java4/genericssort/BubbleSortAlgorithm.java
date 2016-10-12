/*
 *  In the BubbleSort class are compared the object and sorted in a list.
 */

package siit.java4.genericssort;

import java.util.Comparator;

public class BubbleSortAlgorithm {

	public <T> T[] sortObjects(T[] unsorted, Comparator<T> comparator) {
		boolean listCheck = true;

		for (int i = 0; i < unsorted.length - 1; i++) {

			if (comparator.compare(unsorted[i], unsorted[i + 1]) > 0) {
				T aux = unsorted[i];
				unsorted[i] = unsorted[i + 1];
				unsorted[i + 1] = aux;
				listCheck = false;
			}
		}

		if (!listCheck) {
			sortObjects(unsorted, comparator);
		}

		return unsorted;

	}

	public <T extends Comparable<T>> T[] sortPrimitives(T[] unsorted) {
		boolean listCheck = true;

		for (int i = 0; i < unsorted.length - 1; i++) {

			if (unsorted[i].compareTo(unsorted[i + 1]) > 0) {
				T aux = unsorted[i];
				unsorted[i] = unsorted[i + 1];
				unsorted[i + 1] = aux;
				listCheck = false;
			}
		}

		if (!listCheck) {
			sortPrimitives(unsorted);
		}

		return unsorted;
	}
}
