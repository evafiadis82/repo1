package InputStreamLib;

import java.util.Scanner;

public class InputConsoleScanner {
	
	
	
	public static void main(String []args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N elements are going to follow
		
		int n=0 ; //input line
		
		for (int i = 1; i <= N; ++i) {
		      n = sc.nextInt();
		      System.out.println(n);
		}
		
		if (N%2==0)
			System.out.println("even");
		else
			System.out.println("odd");
		
	}

}
