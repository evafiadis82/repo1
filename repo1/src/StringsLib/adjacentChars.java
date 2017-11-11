package StringsLib;

public class adjacentChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < args.length; i++) {
			// System.out.println("arg["+ i+ "]= "+ args[i]);
		}

		String str = args[1];

		int result = adjacent(str);

	}

	public static int adjacent(String str) {

		int strLength = str.length();
		int numberOfRepetitions = 0;

		boolean repeatAgain = true;

		while (repeatAgain) {
			int changesPerLoop = 0;
			for (int i = 0; i < strLength - 1; i++) {

				if (str.charAt(i) == str.charAt(i + 1)) {
					str = swap(str, i);
					// System.out.println ("Conflict found in repetition " + i +
					// str);
					changesPerLoop++;
				}
				
				if (changesPerLoop==0)
					repeatAgain = false;

			}
			numberOfRepetitions++;
		} // repeat again

		System.out.println("NumberOfRepetitions: " + numberOfRepetitions);
		System.out.println("Str after changes: " + str);

		return 1; // 1 if str does not contain any adjacent , 0 if it does
	}

	public static String swap(String str, int c) // c is the index number of
													// conflict
	{
		String newstr = "";

		char chara = str.charAt(c);
		char charb = str.charAt(c + 1);
		char charc = str.charAt(c + 2);

		newstr = str;

		newstr = str.substring(0, c + 1) + charc + charb + str.substring(c + 3, str.length());

		// System.out.println (str.substring(0, c));
		// System.out.println (charc);
		// System.out.println (charb);
		// System.out.println (str.substring(c+1, str.length()));

		return newstr;
	}

}
