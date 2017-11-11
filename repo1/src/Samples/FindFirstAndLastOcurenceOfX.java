package Samples;

import java.util.Scanner;

public class FindFirstAndLastOcurenceOfX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		for(int z=0;z<cases;z++){
			int n = sc.nextInt();
			int array[]=new int[n];
			for(int i=0;i<array.length;i++){
				array[i]=sc.nextInt();
			}
			int key=sc.nextInt();
			int flag=0;
			int j=0;
			int count=0;
			for(int i=0;i<array.length;i++){
				if(array[i]!=key){
					count++;
				}
				
				
			}
			if(count==array.length){
				System.out.print("-1");
				
			}
			else{
			for(int i=0;i<array.length;i++){
				if(array[i]==key){
					j=i;
					System.out.print(i+" ");
					flag=1;
					break;
				}
				
			}
			if(flag==1){
			for(int i=array.length-1;i>0;i--){
				if(array[i]==key){
					System.out.print(i+" ");
					break;
				}
			}
			}
			}
			System.out.println();
		}
		
	}

}
