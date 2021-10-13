package assignment1;

import java.util.ArrayList;

public class QuickerThanMergeSort implements Sort {
	ArrayList<Integer> get_sorted(double[] arr) { // get_sorted function that gets the ending indices of the sorted
													// regions
		ArrayList<Integer> al = new ArrayList<Integer>(); // Declare an ArrayList that stores these indices

		int i = 0;
		{

			while (i < arr.length) {

				while (i < arr.length - 1 && arr[i + 1] >= arr[i]) { // while loop that checks that i is in bound and
					i++; // if the next index is greater than or equal to the current
				}
				int end = i;
				i++;
				al.add(end); // Add the end index of the sorted region to the ArrayList

			}
		}
		return al; // Return the ArrayList of the end indices
	}

	public double[] copy_data(double[] arr, int left, int right) { // copy_data function that copies the data within
																	// each sorted region
		double[] copy = new double[right - left + 1]; // declare a new double [] copy array that stores the data from
														// the rightmost and leftmost indices + 1;
		for (int i = 0; i < copy.length; i++) {
			copy[i] = arr[i + left]; // items get copied over into the copy array.
		}
		return copy;
	}

	void merge(double[] arr, double[] left, double[] right, int start) { // basic merge implementation but taking in the
																			// start parameter from each sorted region
		int ai = start;
		int li = 0;
		int ri = 0;

		while (li < left.length && ri < right.length) {
			if (left[li] <= right[ri])
				arr[ai++] = left[li++];
			else
				arr[ai++] = right[ri++];
		}
		while (li < left.length) {
			arr[ai++] = left[li++];
		}
		while (ri < right.length) {
			arr[ai++] = right[ri++];
		}

	}

	// create a function that calls get_sorted and then copies the sorted data
	// regions from copy_data

	public void sort(double[] arr) { // sort function sorts the sorted regions
		get_sorted(arr); // call get_sorted
		ArrayList<Integer> al = get_sorted(arr); // create an ArrayList to store the end indices of each sorted region
		while (al.size() > 1)
			for (int i = 0; i < al.size() - 1; i += 2) { // for loop that loops through the ArrayList and takes in every
															// other index, as we want the ends, not the starts
				int start = 0; // if our start is at the beginning of the array (no previous sorted region),
								// start = 0
				if (i > 0) // if our start is not in the beginning, it equals the beginning of the next
							// sorted region
					start = 1 + al.get(i - 1);

				double[] left = copy_data(arr, start, al.get(i)); // store the first sorted region into the left array
				double[] right = copy_data(arr, (1 + al.get(i)), al.get(i + 1)); // store the second sorted region into
																					// the right array

				merge(arr, left, right, start); // merge the two sorted regions together, take in the start variable to
												// know when is the next sorted region to merge
				al.remove(al.get(i)); // after merging, remove that region from the ArrayList as we know it is already
										// sorted in order to sort the rest

			}
	}

	public String toString() {
		return "Quicker than Merge Sort";
	}

}