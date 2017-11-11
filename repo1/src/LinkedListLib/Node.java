package LinkedListLib;

public class Node {

	public int data;
	public Node next;

	public Node(int item) {
		data = item;
		next = null;
	}
	
	public Node() {
		
		next = null;
	}

	public Node(int d, Node n, Node p) {
		data = d;
		setNext(n);

	}
	
	public int getData(Node n)
	{
	return n.data;	
	}
	
	public void setNext(Node n) {
		next = n;

	}

	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}

}
