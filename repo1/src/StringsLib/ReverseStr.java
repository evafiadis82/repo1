package StringsLib;

public class ReverseStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = -1234;
		
		  String s = String.valueOf(x);
	      String reverse = new StringBuffer(s).reverse().toString();
		
		System.out.println(reverse);
		
	}

}
