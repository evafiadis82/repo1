package StringsLib;

public class compareStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(equals("101","121"));
		
	}

	public static boolean equals(final String s1, final String s2) {
		return s1 != null && s2 != null && s1.hashCode() == s2.hashCode()
		    && s1.equals(s2);
		}
}
