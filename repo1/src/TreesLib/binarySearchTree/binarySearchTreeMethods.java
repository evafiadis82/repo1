package TreesLib.binarySearchTree;

import TreesLib.Node;

public class binarySearchTreeMethods {

	public static void main(String args[]) {

		// Binary search tree
		Node root = new Node(20);

		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

	}

	 public static int findLCAInBST(Node n, int a, int b) {
		 
         if (n == null)
                return -1;

         if (a > n.value && b > n.value)
                return findLCAInBST(n.right, a, b);

         if (a < n.value && b < n.value)
                return findLCAInBST(n.left, a, b);

         return n.value;

  }
	
	
}
