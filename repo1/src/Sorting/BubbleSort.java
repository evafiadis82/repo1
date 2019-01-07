package Sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 2, 78, 54, 34, 5, 12, 56, 76, 43, 55, 4, 3, 0, -1 };

		array = bubbleSort(array);

		for (int d : array)
			System.out.print(d + " ");

	}

	public static int[] bubbleSort(int[] array) {
		int numberOfSwaps = 1;

		while (numberOfSwaps > 0) {
			numberOfSwaps = 0;

			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					array = Utils.swap(array, i, i + 1);
					numberOfSwaps = 1;
				}
			}

		}

		return array;
	}


}
