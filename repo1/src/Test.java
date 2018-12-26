import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		int nums[] = new int[3];
		
	    nums[0]=1;
	    nums[1]=1;		
	    nums[2]=2;
	    
	   
	    HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
	    //test2
	    for (int i=0; i<nums.length;i++)
        {
            int number = nums[i];
					
					if (hmap.containsKey(number))
					{
						int existingValue = hmap.get(number);
						hmap.put(number, ++existingValue);
					}
					else
						hmap.put(number, 1);
            
        }
        
	System.out.println(hmap.size());
        
    }
	    
	}


