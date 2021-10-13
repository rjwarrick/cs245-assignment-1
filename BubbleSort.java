package assignment1;

public class BubbleSort implements Sort { // Bubble Sort implementation
	void swap(double[] arr, int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void sort(double[] arr) {
		boolean swapped = false;

		for (int i = 1; !swapped && i <= arr.length; i++) {
			swapped = true;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					swapped = false;
				}

			}

		}

	}

	public String toString() {
		return "Bubble Sort";
	}

}
