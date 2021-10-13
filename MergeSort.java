package assignment1;

public class MergeSort implements Sort { // Merge Sort implementation
	public void sort(double[] arr) {
		if (arr.length > 1) {
			double[] left = get_left(arr);
			double[] right = get_right(arr);

			sort(left);
			sort(right);
			merge(arr, left, right);
		}
	}

	void merge(double[] arr, double[] left, double[] right) {
		int ai = 0;
		int li = 0;
		int ri = 0;

		while (li < left.length && ri < right.length)
			if (left[li] <= right[ri])
				arr[ai++] = left[li++];
			else
				arr[ai++] = right[ri++];

		while (li < left.length)
			arr[ai++] = left[li++];

		while (ri < right.length)
			arr[ai++] = right[ri++];

	}

	double[] get_left(double[] arr) {
		int size = arr.length / 2;
		double[] left = new double[size];
		for (int i = 0; i < size; i++) {
			left[i] = arr[i];
		}
		return left;
	}

	double[] get_right(double[] arr) {
		int size = arr.length - arr.length / 2;
		double[] right = new double[size];
		for (int i = 0; i < right.length; i++) {
			right[i] = arr[i + arr.length / 2];
		}
		return right;
	}

	public String toString() {
		return "Merge Sort";
	}
}
