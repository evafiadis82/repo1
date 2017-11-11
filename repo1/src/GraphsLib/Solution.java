package GraphsLib;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static long getMaxScore(long[] arr) {
		long sum = 0;
		HashSet<Integer> hset = new HashSet<Integer>();
		ArrayList<Long> arrlist = new ArrayList<Long>();
		int n = arr.length;
		
		int mod[] = new int[2];
		mod = biggestMod(arr);
		
		long runningSum = 0;
		while (n > 0) {
			int index = calculateIndex(hset, arr, runningSum,mod);
			// System.out.println("receiving index " + index);
			long score = runningSum % arr[index];
			runningSum = runningSum + arr[index];
			arrlist.add(score);
			n--;
		}

		for (int i = 0; i < arrlist.size(); i++)
			sum += arrlist.get(i);

		return sum;
	}

	static int calculateIndex(HashSet hset, long[] arr, long runningSum, int mod[]) {
		int index = 0;
		long score = 0;
		long prevscore = 0;

		for (int i = 0; i < arr.length; i++) {

			//System.out.println(i);
			if (!hset.contains(mod[0]))
			{
				index = mod[0];
				hset.add(index);
				break;
			}
			
			if (!hset.contains(mod[1]))
			{
				index = mod[1];
				hset.add(index);
				break;
			}
			
			if (hset.contains(i))
				continue;

			if (hset.size() == (arr.length - 1)) {
				index = i;
				continue;
			}

			score = runningSum % arr[i];
			System.out.println("Score " + score + " i " + i );
			if (score > prevscore)
				index = i;

			prevscore = score;

		}
		hset.add(index);

		//System.out.println("Returning index " + index + " " + hset.toString());
		return index;
	}

	public static void main(String[] args) {

		/*
		 * Scanner in = new Scanner(System.in); int n = in.nextInt(); long[] a =
		 * new long[n]; for(int a_i=0; a_i < n; a_i++){ a[a_i] = in.nextLong();
		 * }
		 */
		 long[] a = { 5, 8, 4 };
		//long[] a = { 4, 5, 2000 }; //13
		//long[] a = {2, 10, 3};
		long maxScore = getMaxScore(a);
		System.out.println(maxScore);

	}
	
	public static int[] biggestMod(long arr[])
	{
		int[] res = new int[2];
		
		long mod=0;
		long prevmod=0;
		
		for (int i=0; i<arr.length; i++)
		{
			for (int j=0; j<arr.length; j++)
			{
				if (j==i)
					continue;
				
				mod = arr[i]%arr[j];
				System.out.println("mod " + mod + " i "+ i + " j "+ j);
				if (mod>prevmod)
				{
					res[0]=i;
					res[1]=j;
						
				}
				prevmod = mod;
				
			}
			
			
		}
		
		System.out.println("Starting values " + res[0] + " " + res[1]);
		return res;
	}
	
	
}
