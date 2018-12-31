package LinkedListLib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Node head1 = LinkedListLib.randomLinkedList(6, 1, 10);

		int nums[] = new int[7];
		nums[0] = 0;
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 3;
		nums[4] = 4;
		nums[5] = 5;
		nums[6] = 6;

		// nums[4] = 5;
		// nums[4]=4;
		// nums[5]=5;
		// nums[6]=6;

		int mth_element = 1;

		Node head1 = LinkedListLib.createLinkedList(nums);

		LinkedListLib.printListElements(head1);
		
		System.out.println(returnMthElement(head1 , 7, 7 ));
	}

	public static int returnMthElement(Node head , int distance, int n ) //return the mth element from the end of a linked list - Optimum solution with two pointers
	{
		int m_pointer=0;
		
		int n_pointer=0;
		
		int data=0;
		
		if (head==null || head.next==null || distance>=n) //if list has null or one node
			return -1;
		
		Node current = head;
		
		Node rvalue = head;
		
		while (current!=null)
		{
			n_pointer = n_pointer+1;
			
			m_pointer = n_pointer - distance;
			
			if (m_pointer>0)
			{
				data = rvalue.data;
				rvalue=rvalue.next;
			}
			
			System.out.println("N pointer: " + n_pointer + ": M_pointer " + m_pointer);
			
			current = current.next;
		}
		
		return data;
	}

	

	
	
	public static int numComponents(Node head, int[] G) {
		int rvalue = 0;

		HashSet<Integer> hset = new HashSet<Integer>();

		Arrays.sort(G);
		
		Node current = head;
		Node previous = null;

		while (current != null) {
			/*
			 * System.out.println("\ncurrent data " + current.data);
			 * 
			 * if (previous!=null) System.out.println("previous data " +
			 * previous.data); else System.out.println("previous data null");
			 */

			if (previous == null) {
				if (Arrays.binarySearch(G, current.data)>=0)
					rvalue = rvalue + 1;
			} else {
				if (Arrays.binarySearch(G, current.data)>=0 && Arrays.binarySearch(G, previous.data)>=0)
					;
				else if (Arrays.binarySearch(G, current.data)>=0 && Arrays.binarySearch(G, previous.data)<0)
					rvalue = rvalue + 1;

			}

			previous = current;
			current = current.next;

			// System.out.println("Rvalue: " + rvalue);
		}

		return rvalue;
	}
	
	
	public static int numComponentsSol1(Node head, int[] G) {
		int rvalue = 0;

		HashSet<Integer> hset = new HashSet<Integer>();

		for (int i = 0; i < G.length; i++) {
			hset.add(G[i]);
		}

		Node current = head;
		Node previous = null;

		while (current != null) {
			/*
			 * System.out.println("\ncurrent data " + current.data);
			 * 
			 * if (previous!=null) System.out.println("previous data " +
			 * previous.data); else System.out.println("previous data null");
			 */

			if (previous == null) {
				if (hset.contains(current.data))
					rvalue = rvalue + 1;
			} else {
				if (hset.contains(current.data) && hset.contains(previous.data))
					;
				else if (hset.contains(current.data) && !hset.contains(previous.data))
					rvalue = rvalue + 1;

			}

			previous = current;
			current = current.next;

			// System.out.println("Rvalue: " + rvalue);
		}

		return rvalue;
	}

}
