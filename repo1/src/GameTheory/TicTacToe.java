package GameTheory;

import java.util.HashMap;
import java.util.Scanner;

public class TicTacToe {

	
	public static void main (String[] args)
	{
		

		Scanner in = new Scanner(System.in);

		int testcases = in.nextInt();

		for (int T = 0; T < testcases; T++) {

			String[] array = new String[9];
		
			for (int i=0;i<9;i++)
				array[i]=in.next();
				
				String cross = checkCross(array);
				String lines = checkLine(array);
				String columns = checkColumn(array);
					
				
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				
				map.put("X", 0);
				map.put("O", 0);
				map.put("none",0);
				
				
				int x = (Integer)(map.get(cross))+1;
				
				map.put(cross, (Integer)(map.get(cross))+1);
				map.put(lines, (Integer)(map.get(lines))+1);
				map.put(columns, (Integer)(map.get(columns))+1);
				
				if ((Integer)(map.get("X"))>1 || (Integer)(map.get("O"))>1 )
				System.out.println("Invalid");
				else
				System.out.println("Valid");	
			
			
		}
			
		
	}
	
	public static String checkColumn(String[] array)
	{

		String result="";
		
		if ((array[0].equals(array[3]) && array[0].equals(array[6])) || (array[1].equals(array[4]) && array[1].equals(array[7])) || (array[2].equals(array[5]) && array[5].equals(array[8])) )
		return array[0];
		else
		return "none"; 
		
	}
	
	
	public static String checkLine(String[] array)
	{

		String result="";
		
		if ((array[0].equals(array[1]) && array[0].equals(array[2])) || (array[3].equals(array[4]) && array[3].equals(array[5])) || (array[6].equals(array[7]) && array[7].equals(array[8])) )
		return array[0];
		else
		return "none"; 
		
	}
	
	public static String checkCross(String[] array)
	{
		String result="";
		
		if ((array[0].equals(array[4]) && array[0].equals(array[8])) || (array[2].equals(array[4]) && array[2].equals(array[6])) )
		return array[0];
		else
		return "none"; 
		
	}
	
}
