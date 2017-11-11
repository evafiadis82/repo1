package Samples;

import java.util.Scanner;

public class MaxValue {

	public static void main(String[] args)

	{

		Scanner in = new Scanner(System.in);

		int testcases = in.nextInt();

		for (int t = 0; t < testcases; t++) {

			int N = in.nextInt(); // arraysize

			int[] array = new int[N];

			int max = 0;
		
			for (int j = 0; j < N; j++)
				array[j] = in.nextInt();

			for (int i=0; i<N; i++)
			{
				
				for(int j=0; j<N;j++)
				{
					if (j==i)
						continue;
					else
					{
						int temp = (array[i] - i) - (array[j] - j);
						if (max<temp)
						max = temp;
						
					
						
						
					}
				}
					
			}
			
			System.out.println(max);
			
		} // test cases loop

	}

}
