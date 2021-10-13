package assignment1;

import java.util.Random;

public class ManageSort {
	Sort[] algos = { new SelectionSort(), new BubbleSort(), new InsertionSort(), new QuickSort(), new MergeSort() }; // Part 1 Testing, comment this out if testing Part 2
//	Sort[] algos = {new MergeSort(), new QuickerThanMergeSort()};	// Part 2 Testing, comment this out if testing Part 1
	int[] sizes = { 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000 };

	double[] getArray(int size) { // Generate an array of random double instances.
		Random r = new Random();
		double[] arr = new double[size];
		for (int i = 0; i < size; i++) {
			arr[i] = r.nextDouble();
		}
		return arr;

	}

	void getRunTimes() {
		for (int size : sizes) { // Categorize each sorting algorithm to sort the corresponding array size. i.e.
									// 50000, 100000, ...
			for (Sort algo : algos) { // Send a copy of the array to each of the sorting algorithms.
				double[] a = getArray(size);
				long start = System.currentTimeMillis(); // Start timer.
				algo.sort(a); // Sort the array.
				long time = System.currentTimeMillis() - start; // End timer.
				if (isSorted(a))
					System.out.println(algo + " took " + time + " milliseconds."); // If array is sorted, display time.

				else
					System.out.println(algo + " is not sorted."); // If array is not sorted, print this.
			}
			System.out.println("-------------------------------------------"); // Seperate running times based on
																				// the sizes of the arrays.
		}
	}

	public boolean isSorted(double[] arr) { // Checks if the arrays are sorted. If arrays are not sorted, return false.
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ManageSort ms = new ManageSort();
		ms.getRunTimes();

		double[] randomDoubleArray = new double[10];

		for (int i = 0; i < randomDoubleArray.length; i++) {
			randomDoubleArray[i] = Math.random();
		}
	}

}
