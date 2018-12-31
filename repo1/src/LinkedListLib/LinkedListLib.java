package LinkedListLib;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import UtilLib.AssortedMethods;;

public class LinkedListLib {

	/*
	 * Very common code used with linked lists. A node current is initiated and
	 * then loop in list's elements:
	 * 
	 * Node current = head; while (current.next != null) {
	 * 
	 * if (current ....) { //check what you have to check return; }
	 * 
	 * current = current.next;
	 * 
	 * } //while
	 * 
	 * To delete the head, just set: head = head.next;
	 * 
	 */

	public Node deleteDuplicates(Node head) { // method to delete duplicates in
												// linkedList

		HashMap<Integer, Boolean> hmap = new HashMap<Integer, Boolean>();
		Node previous = null;
		Node rhead = head;
		while (head != null) {
			if (hmap.containsKey(head.data)) {
				previous.next = head.next;
			} else {
				hmap.put(head.data, true);
				previous = head;
			}
			head = head.next;
		}

		return rhead;
	}

	public static Node randomLinkedList(int N, int min, int max) { // method to
																	// generate
																	// a
																	// linkenList
		Node root = new Node(AssortedMethods.randomIntInRange(min, max), null, null);
		Node prev = root;
		for (int i = 1; i < N; i++) {
			int data = AssortedMethods.randomIntInRange(min, max);
			Node next = new Node(data, null, null);
			prev.setNext(next);
			prev = next;
		}
		return root;
	}

	public static Node createLinkedList(int nums[]) { // method to generate a
														// linkenList

		Node root = new Node(nums[0]);
		Node prev = root;
		for (int i = 1; i < nums.length; i++) {
			int data = nums[i];
			Node next = new Node(data, null, null);
			prev.setNext(next);
			prev = next;
		}
		return root;
	}

	public Node InsertNth(Node head, int data, int position) { // method to add
																// element in
																// specific
																// position

		Node new_node = new Node(data);
		new_node.data = data;

		int count = 0;
		Node prev = null;
		Node cur = head;

		while (cur != null && count < position) {
			count = count + 1;
			prev = cur;
			cur = cur.next;
		}

		if (count != position)
			System.out.println("Not enough nodes in the list!");
		else if (prev == null) {
			// insert at the first position
			new_node.next = head;
			head = new_node;
		} else // Insert at any other position
		{
			new_node.next = cur;
			prev.next = new_node;
		}

		return head;
	}

	public Node Reverse(Node head) { // method to reverse a list - iteration
										// solution

		Node prev = null;
		Node curr = head;
		while (curr != null) {
			Node nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;

	}

	public Node reverseList(Node head) { // method to reverse a list - recursive
											// solution
		if (head == null || head.next == null)
			return head;
		Node p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

	public boolean hasCycle_HashSetSolution(Node head) { // method to detect
															// cycle
		HashSet<Node> nodes = new HashSet<Node>();
		return hasCycleAdd(head, nodes);
	}

	boolean hasCycleAdd(Node head, HashSet nodes) {

		if (head == null)
			return false;

		if (nodes.contains(head))
			return true;
		else {
			nodes.add(head);
			return hasCycleAdd(head.next, nodes);

		}

	}

	public static boolean hasCycle_RunnerSolution(Node head) { // detect cycle
																// method with
																// runners

		Node fast = head;
		Node slow = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}
		return false;

	}

	public int GetNode(Node head, int n) { // method to return Node in specific
											// position

		Node tail = new Node();
		tail = head;

		int counter = 0;

		while (tail.next != null) {

			tail = tail.next;
			counter = counter + 1;
		}

		int i = 0;
		tail = head;

		while (i != (counter - n)) {
			i++;
			tail = tail.next;
		}

		return tail.data;

	}

	public static void printListElements(Node head) {

		System.out.println("");
		System.out.println("LinkedList data: ");
		while (head != null) {
			System.out.print(head.getData(head) + " ");
			head = head.next;
		}
		System.out.println("");
	}

	public static Node mergeLists(Node head1, Node head2) { // a solution would
															// be to add all
															// data of the
															// second list to
															// end of the first
															// list and then
															// sort

		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;

		Node temp = head1;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = head2;

		return sortList(head1);

	}

	public static Node sortList(Node head) { // method to sort a linked list

		if (head == null)
			return head;

		boolean rescan = true;
		while (rescan) {
			rescan = false;
			Node temp = head;

			while (temp.next != null) {
				if (temp.data > temp.next.data) {
					int tempvalue = temp.data;
					temp.data = temp.next.data;
					temp.next.data = tempvalue;
					rescan = true;
				}
				temp = temp.next;
			} // while
		} // rescan
		return head;
	}

	public static Node removeElements(Node head, int val) // remove all List
															// elements with
															// value val
	{
		if (head == null) {
			return null;
		}

		Node prev = head;
		Node current = head.next;

		while (current != null) {
			if (current.data == val) {
				prev.next = current.next;
			} else {
				prev = current;
			}
			current = current.next;
		}

		if (head.data == val)
			return head.next;
		else
			return head;

	}

	public static Node removeElementsRecur(Node head, int val) { // remove
																	// elemenes
																	// recursive
																	// solution
		if (head == null) {
			return null;
		}

		if (head.data == val) {
			return removeElements(head.next, val);
		}

		head.next = removeElements(head.next, val);

		return head;
	}

	public Node middleNode(Node head) { // slow and fast pointers // where two
										// lists have intersection
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static Node middleNodeSolution2(Node head) { // where two lists have
														// intersection

		if (head == null)
			return null;

		Node rvalue = head;
		Node current = head;

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int i = 0;

		while (current.next != null) {
			hmap.put(i, current.data);
			current = current.next;
			i = i + 1;

			if (current.next == null) {
				i = i + 1;
				hmap.put(i, current.data);
			}
		}

		int hsize = hmap.size();

		int node = (hsize / 2);
		int j = 0;

		while (j < node) {
			rvalue = rvalue.next;
			j++;
		}

		rvalue.next = null; // in order to select only one

		System.out.println("Keys: " + hmap.keySet() + " Values: " + hmap.values());

		return rvalue;
	}

	public static boolean isPalindrome(Node head) {

		Stack<Integer> pal = new Stack<Integer>();

		Node current = head;

		while (current != null) {
			pal.push(current.data);
			current = current.next;
		}

		current = head;

		while (current != null) {
			int n = pal.pop();

			// System.out.println("Comparing: " + n +" " + current.data);

			if (n != current.data)
				return false;

			current = current.next;
		}

		return true;
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
}
