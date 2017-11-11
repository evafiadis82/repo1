package Samples;

import java.util.HashMap;
import java.util.Scanner;

public class PythagoreanTriplet {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int testcases = in.nextInt();

		for (int T = 0; T < testcases; T++) {

			int arraysize = in.nextInt();

			int[] nums = new int[arraysize];

			for (int i = 0; i < arraysize; i++) {
				int nextNumber = in.nextInt();
				nums[i] = nextNumber;
			}

			boolean hasFound = false;

			for (int i = 0; i < arraysize; i++) {

				for (int j = 0; j < arraysize; j++) {
					if (j == i)
						continue;
					else {

						
						for (int k = 0; k < arraysize; k++) {
								
							if (k==i || k==j)
								continue;
							
							if ((nums[i]*nums[i]) == ((nums[j]*nums[j]) + (nums[k]*nums[k])))
									{
								    hasFound=true;
								    break;
									}
							
							if (hasFound)
								break;
							
						}

					}

					if (hasFound)
						break;

				}

				if (hasFound)
					break;

			}

			if (!hasFound)
				System.out.println("No");
			else
				System.out.println("Yes");
		}

	}

}
