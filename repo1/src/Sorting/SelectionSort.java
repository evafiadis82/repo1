package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
	int[] array = { 2, 78, 54, 34, 5, 12, 56, 76, 43, 55, 4, 3, 0, -1 };

	array = SelectionSort(array);

	for (int d : array)
		System.out.print(d + " ");
	}	


	public static int[] SelectionSort(int[] array) {

		
		for (int i=0; i<array.length; i++)
		{
			
			int element_index = findminelementidx(array,i);
		
			if (element_index>i)
				array=Utils.swap(array,i,element_index);
		}
		return array;
	}
		
		public static int findminelementidx(int[] array, int start)
		{
			int min_element = array[start];
			int min_element_idx = start;
			
			for (int i=start+1; i<array.length; i++)
			{
				if (array[start]>array[i] && min_element>array[i])
					{
						min_element = array[i];
						min_element_idx = i;
					}
			}
			
			return min_element_idx;
		}
}
