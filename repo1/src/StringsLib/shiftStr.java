package StringsLib;

import java.util.Arrays;

public class shiftStr {

	public static void shiftArr(int[] arr, int k) {

		if (k == 0 || arr == null || arr.length==0 || k == arr.length)
			return;

		int n = arr.length;

		if (k>n)
			k = k-n;
		
		int temp[] = new int[n];

		System.arraycopy(arr, n - k, temp, 0, k);
		System.arraycopy(arr, 0, temp, k, n - k);
		arr = temp;
		System.out.println(Arrays.toString(temp) + " " + Arrays.toString(arr));

	}
	
}
