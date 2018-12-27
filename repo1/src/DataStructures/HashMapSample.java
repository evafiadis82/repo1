package DataStructures;

import java.util.*;

public class HashMapSample {

	public static void main(String[] args)

	{

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {

			int number = sc.nextInt();

			if (hmap.containsKey(number)) {
				int existingValue = hmap.get(number);
				hmap.put(number, ++existingValue);
			} else
				hmap.put(number, 1);

		}

		// Print result
		for (Map.Entry m : hmap.entrySet())
			System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
	}

	// Loop in hasmap
	// for (Map.Entry me : hmap.entrySet()) {
	// System.out.println("\n Key: " + me.getKey() + " & Value: " +
	// me.getValue());
	// }

}
