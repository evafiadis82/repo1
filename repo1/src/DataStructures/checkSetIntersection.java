package DataStructures;

import java.util.HashSet;

public class checkSetIntersection {

	public static void main(String args[])
	{
		
		String s1="hello";
		
		String s2="tst";
				
		System.out.println(twoStrings (s1,s2));
	}
	
	
	static String twoStrings(String s1, String s2) {


		HashSet<Integer> set1 = new HashSet<Integer>();
		
		for (int i=0; i<s1.length();i++)
		set1.add((int) s1.charAt(i));
		
		for (int i=0; i<s2.length(); i++)
		{
			if (set1.contains((int)s2.charAt(i)))
					return "YES";
		}
		
		return "NO";
    }

	
}
