package StringsLib;

public class RoundRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "abcd";
		
		String b = "cdab";
		
		int N = a.length();
		
		String newStr=a;
		
		for (int i=0; i<N;i++)
		{
			
			newStr = newStr.charAt(N-1) + newStr.substring(0,N-1);
			if (newStr.equals(b))
				System.out.println(1);
			//System.out.println(newStr);
			
		}
		
		
	}

}
