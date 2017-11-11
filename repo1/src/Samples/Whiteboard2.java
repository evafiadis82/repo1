package Samples;

public class Whiteboard2 {

	public static void main(String[] args) {

		//int arr[] = { 1, -3 ,9 , -7, 8};
		
		//System.out.println(maxSubArray(arr));
		
		String[] grid = {"000", "00X", "000"};
		
         int res[] = new int[2]; 
        		 
         res = findTheBug(grid);
         
        // for (int i=0;i<res.length;i++)
        // {
        //	 System.out.println(res[i]);
        // }
         
         
	}

	
	 public static int[] findTheBug(String[] grid){
	     
		 int[] result = new int[2];
		 
		 int i=0;
		 int j = grid.length-1;
		 int index=0;
		 String str="";
		 
		while (i<=j)
		{
			
			
			if(grid[i].indexOf("X")>=0)
			{
				index=i;
				str = grid[i];
				break;
			} else if (grid[j].indexOf("X")>=0)
			{
				index=j;
				str = grid[j];
				break;
			}
			i++;
			j--;
						
		}
		
		result[0] = index;
		
		for (int k=0; k<str.length(); k++)
		{
			if(str.charAt(k)=='X')
			{
				result[1]=k;
			}
		}
		 
		System.out.println("result " + result[0] + " " + result[1]);
		
		 return result;
	    }
	
	

	public static int maxSubArray(int[] nums) {
	     int sum = nums[0];
			int tempsum = nums[0];

			for (int i = 0; i < nums.length; i++)

			{
				tempsum = nums[i];
				sum = Math.max(sum, tempsum);
				for (int j = i + 1; j < nums.length; j++) {

					tempsum = tempsum + nums[j];

					System.out.println("i j " + i + " " + j + " tempsum " + tempsum);

					sum = Math.max(sum, tempsum);

				}

			}

			return sum;
	     
	        
	    }

	
	
	
}
