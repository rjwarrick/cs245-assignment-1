package assignment1;

public class SelectionSort implements Sort { // Selection Sort implementation
	void swap(double[] arr, int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	int findSmallest(double[] arr, int start) {
		int smallest = start;
		for (int i = start + 1; i < arr.length; i++) {
			if (arr[i] < arr[smallest])
				smallest = i;
		}
		return smallest;
	}

	public void sort(double[] arr) {
		for (int i = 0; i < arr.length - 0; i++) {
			swap(arr, i, findSmallest(arr, i));
		}
//		return arr;
	}

	public String toString() {
		return "Selection Sort";
	}
}
