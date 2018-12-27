package DataStructures;

import java.util.HashMap;

public class searchWithTwoPointersInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = new int[2];
		int rarray[] = new int[2];

		nums[0] = 1;
		nums[1] = 4;
		//nums[2] = 8;
		//nums[3] = 8;
		//nums[4] = 8;
		//nums[5] = 10;

		int target = 4;
		int rvalue = -1;
		int lvalue = -1;

		// System.out.println(nums.length/2);

		for (int i = 0; i < nums.length; i++) {
			
			int j = nums.length - 1 - i;
		
			if (rvalue>-1 && i > rvalue)
				break;

			System.out.println("\ni " + i + " j " + j);

			if (nums[i] == target && lvalue == -1)
				lvalue = i;

			if (nums[j] == target && rvalue == -1)
				rvalue = j;

			System.out.println(lvalue + " " + rvalue);

		}
		
		rarray[0]=lvalue;
		rarray[1]=rvalue;

	}

}
