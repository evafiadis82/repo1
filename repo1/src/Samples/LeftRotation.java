package Samples;

import java.util.Scanner;

public class LeftRotation {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int d = in.nextInt();
	        int a[] = new int[n];
	        
	        if (d>n)
	        	d = d-n; //optimization
	        
	        for(int i=0; i < n; i++){
	            a[i] = in.nextInt();
	        }
	        int temp[] = new int[d];
	        
	        
	       System.arraycopy(a, 0, temp, 0, d);
	        
	       System.arraycopy(a, d, a, 0, n-d);
	       
	       System.arraycopy(temp, 0, a, n-d, d);
	       
	        for (int k=0; k<n;k++)
	        	System.out.print(a[k]+" ");
		
	}

	
	
}
