package Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2, 78, 54, 34, 5, 12, 56, 76, 43, 55, 4, 3, 0, -1 };

		List<Integer> unsorted = new LinkedList();
		
		unsorted.add(5);
		unsorted.add(8);
		unsorted.add(10);
		unsorted.add(-15);
		unsorted.add(90);
		unsorted.add(-5);
		unsorted.add(7);
		unsorted.add(58);
		
		List<Integer> lst = mergeSort(unsorted);

		for (int l : lst)
			System.out.print(l + " ");
		
	}
	
	public static List<Integer> mergeSort(List<Integer> list) {
		
		if (list.size()<2)
			return list;
		
		int median=(list.size())/2;
		
		List<Integer> left =  list.subList(0, median);
		List<Integer> right =  list.subList(median, list.size());
		
		return merge(mergeSort(left),mergeSort(right));
	}
	
	public static List<Integer> merge(List<Integer> left,List<Integer> right )
	{
		List<Integer> merged = new ArrayList<Integer>(left.size() + right.size());
		
		int leftPtr=0;
		int rightPtr=0;
		
		while (leftPtr<left.size() && rightPtr<right.size())
		{
			int left_num = left.get(leftPtr);
			int right_num = right.get(rightPtr); 
			
			if (left_num<right_num)
			{
				merged.add(left_num);
				leftPtr = leftPtr+1;
			}
				else 
					{
					merged.add(right_num);
					rightPtr = rightPtr+1;
					}
		}
		
		while (leftPtr<left.size())
		{	
			int left_num = left.get(leftPtr);
			merged.add(left_num);
			leftPtr = leftPtr+1;			
		}
		
		while (rightPtr<right.size())
		{	
			int right_num = right.get(rightPtr);
			merged.add(right_num);
			rightPtr = rightPtr+1;			
		}
		
		return merged;
	}

}
