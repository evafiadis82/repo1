package DataStructures;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * @author VAF
 *
 */

public class searchInArrayWithHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = new int[3];
		
	    nums[0]=3;
	    nums[1]=2;		
	    nums[2]=4;
	    
	    int target = 6;
	   
	    //int array to hashmap
	    HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
	    
	    for (int i=0; i<nums.length;i++)
	    	hmap.put(nums[i],i);

	    int rvalue[] = new int[2];
	    
	    for (int i=0;i<nums.length;i++)
        {
	    int n1=nums[i];
	    int n2=target - n1;
        
	    System.out.println(n1 + " " + n2);
	    
        if (hmap.containsKey(n2))
        {
        	 rvalue[0]=i;
        	 rvalue[1]=hmap.get(n2);
        	
        	//System.out.println("true");
        	 if (rvalue[0]!=rvalue[1])
           	break;
        }
        else
        	System.out.println("false");
        
        }
		
	    System.out.println("" + rvalue[0]+ " " + rvalue[1]);
		
	}

}
