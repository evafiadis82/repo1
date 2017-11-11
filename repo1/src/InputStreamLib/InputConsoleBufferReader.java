package InputStreamLib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputConsoleBufferReader {

	public static void main(String[] args) {

		System.out.println("Reading Console\n");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		int counter = 0;
		int numberOfLines = 4;
		while (counter < numberOfLines) {
			String line;
			try {
				line = reader.readLine();
				System.out.println(line + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
		} // while

		// Printing the read line

	}

}
