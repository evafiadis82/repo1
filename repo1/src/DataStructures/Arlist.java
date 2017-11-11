package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> ls = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N elements are going to follow
		int n = 0; // input line
		for (int i = 1; i <= N; ++i) {
			n = sc.nextInt();
			System.out.println(n);
			insertSorted(ls, n);
		}

		System.out.println("Sorted arrlist\n");
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i));
		}

		//
		int size = ls.size();
		if (size % 2 == 0) {
			System.out.println("\nEven case: " + ls.get(size / 2 - 1) + " " + ls.get((size / 2)));
			System.out.println("\nSum: " + (ls.get(size / 2 - 1) + ls.get((size / 2))) / 2);
		} else
			System.out.println((ls.get(size - 1) - 1) / 2);
		//
	}

	public static void insertSorted(List<Integer> arr, int n) {

		int i = 0;
		while (i < arr.size() && n > arr.get(i))
			++i;
		arr.add(i, n);
	}

	public static int arraylistSum(ArrayList<Integer> arrlist) {

		int sum = 0;

		for (int i = 0; i < arrlist.size(); i++) {
			sum += arrlist.get(i);
		}

		return sum;

	}

}
