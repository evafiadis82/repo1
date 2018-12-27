import java.util.HashMap;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = new String[1];
		
		strs[0]="flower";
		//strs[1]="flow";
		//strs[2]="flight";
		
		String rvalue = putStringInHashMap(strs);
		
	}

	public static String putStringInHashMap(String[] strs) {

		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		
		for (int i=0; i<strs.length;i++)
		{
			
			for (int j=0; j<strs[i].length(); j++)
			{
				int number= strs[i].charAt(j);

				if (hmap.containsKey(number))
				{
					int existingValue = hmap.get(number);
					hmap.put(number, ++existingValue);
				}
				else
					hmap.put(number, 1);
			}
				
			
		}
		
		System.out.println(hmap.values());
		
		return null;

	}

}
