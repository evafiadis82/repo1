package Sorting;

public class Utils {

	public static int[] swap(int[] array, int i, int j) {
		
		//System.out.println("Switching element in position " + i + " with value " + array[i] + " with element in position "+ j + " with value " + array[j]);
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
		
		
		return array;
	}
	
}
