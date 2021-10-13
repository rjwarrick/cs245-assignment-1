package assignment1;

public class QuickSort implements Sort { // Quick Sort Implementation
	void swap(double[] arr, int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void quicksort(double[] arr, int bot, int top) {
		if (bot < top) {
			int p = partition(arr, bot, top);
			quicksort(arr, bot, p - 1);
			quicksort(arr, p + 1, top);
		}
	}

	public void sort(double[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	int partition(double[] arr, int left, int right) {
		int pivot = right;
		int bot = left;
		int top = right - 1;

		if (left < right) {
			while (bot <= top) {
				while (bot < right && arr[bot] < arr[pivot])
					++bot;
				while (top >= bot && arr[top] >= arr[pivot])
					--top;
				if (bot < top)
					swap(arr, bot, top);
				else
					swap(arr, bot, pivot);
			}

		}
		return bot;

	}

	public String toString() {
		return "Quicksort";
	}

}
