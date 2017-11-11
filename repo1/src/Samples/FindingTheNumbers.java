package Samples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindingTheNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner in = new Scanner(System.in);
		
		int testcases = in.nextInt();
		
		for (int i=0;i<testcases; i++)
		{
			
			int N = in.nextInt();
			
			HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
			
			int TotalInput = 2*N+2;
			
			for (int j=0;j<TotalInput;j++)
			{
				int number = in.nextInt();

				if (hmap.containsKey(number))
				{
					int existingValue = hmap.get(number);
					hmap.put(number, ++existingValue);
				}
				else
					hmap.put(number, 1);
				
				
			}
			
			

	        // Print result
			int counter=0;
			int numberA=0 ;
			int numberB=0 ;
			for (Map.Entry m:hmap.entrySet())
	        { 
	          if ((Integer)m.getValue()==1)
	          {
	
	          if (counter == 0)
	          numberA = (Integer)m.getKey();
	          else
	          numberB = (Integer)m.getKey();
	          
	          counter++;
	          }
	        }
			
			if (numberA> numberB)
				System.out.println(numberB + " " + numberA);
			else
				System.out.println(numberA + " " + numberB);
			
	    }
			
			
		} //for
		
		
		
		
		
	

}
