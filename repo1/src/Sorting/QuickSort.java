package Sorting;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 2, 78, 54, 34, 5, 12, 56, 76, 43, 55, 4, 3, 0, -1 };

		array = QuickSort(array);

		for (int d : array)
			System.out.print(d + " ");

	}

	public static int[] QuickSort(int[] array) {
	
		if (array.length<2)
			return array;
		
		int pivotIndex = array.length/2;
		int pivotData =  array[pivotIndex];
		
		int leftCount=0;
		
		for( int i = 0; i < array.length; ++i ){
			if( array[i] < pivotData ) 
				leftCount=leftCount+1;
			}
		
		
		int[] left = new int[leftCount];
		int[] right = new int[array.length-leftCount-1];
		
		int l=0;
		int r=0;
		
		for (int i=0; i<array.length; i++)
		{
			if (i==pivotIndex)
				continue;
			
			if (array[i]<pivotData)
			{
				left[l]=array[i];
				l=l+1;
			}
			

			if (array[i]>pivotData)
			{
				right[r]=array[i];
				r=r+1;
			}
		}
		
		QuickSort(left);
		QuickSort(right);
		
		System.arraycopy(left, 0, array, 0, left.length);
		array[leftCount]= pivotData;
		System.arraycopy(right, 0, array, leftCount+1, right.length);
		
		return array;
	}

}
