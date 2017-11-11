package Samples;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		Scanner in = new Scanner(System.in);

		int testcases = in.nextInt();

		for (int T = 0; T < testcases; T++) {

			int N = in.nextInt();
			
			for(int i=1; i<=N; i++)
			{
				if (i%3==0 && i%5==0)
					System.out.println("FizzBuzz");
				else if (i%5==0)
					System.out.println("Buzz");
				else if (i%3==0)
					System.out.println("Fizz");
				else
					System.out.println(i);
			}
			
			
		}
		
		
	}

}
