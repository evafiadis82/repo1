package InputStreamLib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		File f = new File("e:\\cisco.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			
			String line;
			while ((line = br.readLine()) != null) 
			{
			       // process the line.
				System.out.println(line);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
		
	}

}
