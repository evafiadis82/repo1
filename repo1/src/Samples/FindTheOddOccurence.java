package Samples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindTheOddOccurence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();

		for (int z = 0; z < cases; z++) {

			int n = sc.nextInt();

			int array[] = new int[n];
			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

			for (int i = 0; i < array.length; i++) {

				array[i] = sc.nextInt();

				if (hmap.containsKey(array[i]))
					hmap.put(array[i], hmap.get(array[i]) + 1);
				else
					hmap.put(array[i], 1);

			}

			for (Map.Entry m : hmap.entrySet()) {

				if (!((Integer)m.getValue()%2==0))
					System.out.println(m.getKey());
				//System.out.println(m.getValue());
				
			}
		}

	}

}
