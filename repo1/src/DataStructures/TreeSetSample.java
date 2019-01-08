package DataStructures;

import java.util.TreeSet;

public class TreeSetSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	TreeSet<Integer> tset = new TreeSet<Integer>();
		
		
		tset.add(40);
		tset.add(30);
		tset.add(20);
		tset.add(10);
	
		
		System.out.println("Floor: " +  tset.floor(15));
		System.out.println("Ceiling:" + tset.ceiling(15));
		
		System.out.println("headSet: " + tset.headSet(21));
		System.out.println("TailSet: " + tset.tailSet(25));
		
		System.out.println("pollast: " + tset.pollLast());
		System.out.println("pollFirst: " + tset.pollFirst());
		
	}

}
