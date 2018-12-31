import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] emails = new String[3];

		emails[0] = "test.email+alex@leetcode.com";
		emails[1] = "test.e.mail+bob.cathy@leetcode.com";
		emails[2] = "testemail+david@lee.tcode.com";

		
		
		// numUniqueEmails(emails);

		int[] socks = new int[7];

		socks[0] = 1;
		socks[1] = 2;
		socks[2] = 1;
		socks[3] = 2;
		socks[4] = 1;
		socks[5] = 3;
		socks[6] = 3;

		// int socksnumber = sockMerchant(socks.length, socks);
		// System.out.println(socksnumber);

		int[] c = new int[8];

		c[0] = 5;
		c[1] = 1;
		c[2] = 5;
		c[3] = 2;
		c[4] = 5;
		c[5] = 3;
		c[6] = 5;
		c[7] = 4;

		
		String  str = "01234567";
		
		char[] carray = str.toCharArray() ;
		
		for (char ci: carray)
			System.out.println((int)ci - '0');
		

	}

	public static List<Integer> selfDividingNumbers(int left, int right) {

		List<Integer> rlist = new ArrayList<Integer>();

		for (int i = left; i <= right; i++) {
			int num = i;

			boolean add_to_set = true;

			while (num != 0) {
				int digit = num % 10;

				//System.out.println("Digit: " + digit);
				
				if (digit == 0) {
					add_to_set = false;
					break;
				}

				if (i % digit != 0)
					add_to_set = false;

				num = num / 10;
			}

			if (add_to_set)
				rlist.add(i);

		}

		return rlist;
	}

	public static boolean judgeCircle(String moves) {

		int x = 0;
		int y = 0;

		for (char c : moves.toCharArray()) {
			if (c == 'U')
				y = y + 1;
			else if (c == 'D')
				y = y - 1;

			if (c == 'L')
				x = x + 1;
			else if (c == 'R')
				x = x - 1;

		}

		if (x == 0 && y == 0)
			return true;
		else
			return false;
	}

	public static int[] sortArrayByParity(int[] A) {

		ArrayList<Integer> even = new ArrayList<Integer>();
		ArrayList<Integer> odd = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {

			if (A[i] % 2 == 0)
				even.add(A[i]);
			else
				odd.add(A[i]);
		}

		System.out.println("Even: " + even.toString() + " Odd: " + odd.toString());

		int j = 0;
		for (int ev : even) {
			A[j] = ev;
			j++;
		}

		int k = even.size();
		for (int od : odd) {
			A[k] = od;
			k++;
		}

		return A;

	}

	public static int uniqueMorseRepresentations(String[] words) {

		String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

		HashSet<String> hset = new HashSet<String>();

		for (int i = 0; i < words.length; i++) {

			StringBuilder str = new StringBuilder();

			for (int j = 0; j < words[i].length(); j++) {
				int n = words[i].charAt(j) - 97;
				str.append(morse[n]);
			}
			hset.add(str.toString());

		}

		return hset.size();
	}

	public static int repeatedNTimes(int[] A) {
		int rvalue = 0;

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			int number = A[i];
			if (hmap.containsKey(number)) {
				int existingValue = hmap.get(number);
				existingValue = existingValue + 1;

				if (existingValue == (A.length) / 2)
					return A[i];

				hmap.put(number, existingValue);
			} else
				hmap.put(number, 1);
		}

		return rvalue;
	}

	public static long repeatedString(String s, long n) {

		long rvalue = 0;

		int len = s.length();

		long times = (n / len);
		int left = (int) (n % len);

		long numofas = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				numofas = numofas + 1;
		}

		numofas = numofas * times;

		for (int i = 0; i < left; i++) {
			if (s.charAt(i) == 'a')
				numofas = numofas + 1;
		}

		// System.out.println("times " + times + " modulo " + left );

		return numofas;

	}

	public static long repeatedString2(String s, long n) {

		long rvalue = 0;

		int len = s.length();

		String final_string = "";

		while (final_string.length() < n) {
			final_string = final_string + s;
		}

		final_string = final_string.substring(0, (int) n);

		for (int i = 0; i < final_string.length(); i++) {
			if (final_string.charAt(i) == 'a')
				rvalue = rvalue + 1;
		}

		// System.out.println(final_string);

		return rvalue;

	}

	public static int jumpingOnClouds(int[] c) {
		int len = c.length;
		int steps = 0;

		for (int i = 0; i < len - 1; i++) {
			// System.out.println(i);
			if (i == len - 2) {
				steps = steps + 1;
				break;
			}

			if (c[i + 2] == 0) {
				steps = steps + 1;
				i = i + 1;
				// System.out.println("Long jump");
			} else if (c[i + 1] == 0) {
				steps = steps + 1;
				// System.out.println("Short jump");
			}

		}

		return steps;
	}

	public static int sockMerchant(int n, int[] ar) {

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {

			int number = ar[i];

			if (hmap.containsKey(number)) {
				int existingValue = hmap.get(number);
				hmap.put(number, ++existingValue);
			} else
				hmap.put(number, 1);

		}

		int rvalue = 0;

		for (Map.Entry me : hmap.entrySet()) {
			int value = (int) me.getValue();

			rvalue = rvalue + value / 2;
		}

		return rvalue;
	}

	public static int numUniqueEmails(String[] emails) {

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		for (int i = 0; i < emails.length; i++) {
			// System.out.println("\nEmail: " + emails[i]);
			String localname;
			String domain;

			String[] emailsplit = new String[2];
			emailsplit = emails[i].split("@");

			localname = emailsplit[0];
			domain = emailsplit[1];

			localname = localname.substring(0, localname.indexOf("+"));
			localname = localname.replace(".", "");

			emails[i] = localname + domain;

			// System.out.println("Localname: " + localname + " Domain: " +
			// domain);

			if (hmap.containsKey(emails[i])) {
				int existingValue = hmap.get(emails[i]);
				hmap.put(emails[i], ++existingValue);
			} else
				hmap.put(emails[i], 1);

		}
		return hmap.size();

	}

}
