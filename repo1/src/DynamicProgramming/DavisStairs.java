package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class DavisStairs {

	static int ways = 0;

	static HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int testcases = in.nextInt();

		for (int T = 0; T < testcases; T++) {

			int N = in.nextInt();

			ways = 0;
			ways = calculate(N, hmap);

			System.out.println(ways);

		}

	}

	public static int calculate(int steps, HashMap hmap) { //contains memorization with hashmap

		if (hmap.containsKey(steps))
			return (Integer) hmap.get(steps);
		else {
			if (steps == 1)
			{
				ways = 1;
				hmap.put(1,1);
			}
			else if (steps == 2)
			{
				ways = 2;
				hmap.put(2,2);
			}
			else if (steps == 3)
				{
				ways = 4;
				hmap.put(3,4);
				}
			else
			{
				ways = calculate(steps - 1, hmap) + calculate(steps - 2, hmap) + calculate(steps - 3, hmap);
				hmap.put(steps,ways );
			}
		}
		// System.out.println("Call for input " + steps + " returned " + ways);

		return ways;
	}

}
