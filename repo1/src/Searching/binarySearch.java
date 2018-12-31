package Searching;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = new int[9];
		
		nums[0]= 0;
		nums[1]= 1;
		nums[2]= 5;
		nums[3]= 9;
		nums[4]= 12;
		nums[5]= 16;
		nums[6]= 18;
		nums[7]= 20;
		nums[8]= 30;
		
		int target =30;
		
		System.out.println(binarySearch(nums , target, 0, nums.length-1));
			
	}
	
	public static int binarySearch(int nums[] , int target, int left, int right)
	{
		if (target==nums[left])
			return left;
		
		if (target == nums[right])
			return right;
		
		int median = left + (right-left)/2; //better solution 
		//int median = (left + right)/2; perhaps it overflows
		
		if ((median == left || median == right) && (nums[left]!=target && nums[right]!=target))
			return -1;
		
		System.out.println("Left: " +left + " Right: " + right + " Median: " + median);
		
		if (target>nums[median])
			return binarySearch(nums, target, median,  right);
		else if (target<nums[median])
			return binarySearch(nums, target, left,  median);
		else if (target==nums[median])
			return median;
		
		return -1;
		
	}

}
