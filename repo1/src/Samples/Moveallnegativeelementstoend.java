package Samples;

import java.util.ArrayList;
import java.util.Scanner;

public class Moveallnegativeelementstoend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int testcases = in.nextInt();

		for (int i = 0; i < testcases; i++) {

			int arraysize = in.nextInt();

			ArrayList<Integer> pos = new ArrayList<Integer>();
			ArrayList<Integer> neg = new ArrayList<Integer>();

			
			for (int j = 0; j < arraysize; j++) {
				int nextnumber = in.nextInt();

				if (nextnumber >= 0)
					pos.add(nextnumber);
				else
					neg.add(nextnumber);

			}

			for (int j = 0; j < pos.size(); j++)
			System.out.print(pos.get(j)+" ");
				
			

			for (int j = 0; j < neg.size(); j++)
				System.out.print(neg.get(j)+" ");
			
			System.out.println();
			

		} // for

	}

}
