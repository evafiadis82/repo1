package Samples;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("Starting");
		
		int arr[ ] = new int[5];
		
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		Set<Integer> hset = new HashSet<>();
		
		arr[0]=0;
		arr[1]=1;
		arr[2]=4;
		arr[3]=0;
		arr[4]=3;
		
		
			System.out.println(" searchX arr[0]" + " result "+ searchX(arr,2,arr[0],hmap,hset,2,4));
			System.out.println(" searchX arr[0]" + " result "+ searchX(arr,2,arr[1],hmap,hset,2,4));
			System.out.println(" searchX arr[0]" + " result "+ searchX(arr,2,arr[2],hmap,hset,2,4));
			//System.out.println(" searchX arr[0]" + " result "+ searchX(arr,2,arr[3],hmap,hset));
			//System.out.println(" searchX arr[0]" + " result "+ searchX(arr,2,arr[4],hmap,hset));
			
		for (int key : hmap.keySet()) {
		   System.out.println("key " + key + " value " + hmap.get(key));
		}
		

		
		Object obj = Collections.min(hset); 
        System.out.println(obj);  
	}
	
	
	
	public static boolean searchX(int arr[],int x, int key, HashMap map, Set hset, int l , int r)
	{
		int counter=0;
		
		if (map.containsKey(key))
			return false;
		else
			map.put(key,1);
		
		for (int i=l; i<=r;i++)
		{
			if (arr[i]==key)
			counter=counter+1;
			
			if (counter>x)
				return false;
		}
		
		
		map.put(key, counter);
		
		if (counter==x)
	    hset.add(key);
		
		if (counter==x)
		return true;
		else 
	    return false;
	}

}
