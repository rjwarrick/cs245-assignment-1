package assignment1;

public class InsertionSort implements Sort {
	public void sort(double[] arr) {
		for (int i = 1; i < arr.length; i++) {
			double temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				--j;
			}
			arr[j + 1] = temp;
		}

	}

	public String toString() {
		return "Insertion Sort";
	}

}
