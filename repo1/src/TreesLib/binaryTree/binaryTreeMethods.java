package TreesLib.binaryTree;

import TreesLib.Node;

public class binaryTreeMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   //Binary tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right = new Node(3);
        root2.right.right = new Node(7);
        root2.right.left = new Node(6);
		
	}

	
	/*
     * the distance from n1 to n2 can be computed as the distance from the root
     * to n1, plus the distance from the root to n2, minus twice the distance
     * from the root to their lowest common ancestor.
     */
     public static int distanceBetweenNodesinBT(Node node, int n1, int n2)
     {
           
            Node CA = findLCAinBT(node, n1, n2);
           
           
            int result =  distanceFromRootInBT(node, n1, 0) + distanceFromRootInBT(node, n2, 0) -2* distanceFromRootInBT(node, CA.value, 0);
            return result;
           
     }
    

     public static int distanceFromRootInBT(Node node, int n1, int counter) {
            if (node == null)
                   return -1;

            if (node.value == n1)
                   return counter;

            counter = counter + 1;

            return Math.max(distanceFromRootInBT(node.left, n1, counter), distanceFromRootInBT(node.right, n1, counter));

     }
    

     public static Node findLCAinBT(Node node, int n1, int n2) {
            // Base case
            if (node == null)
                   return null;

            if (node.value == n1 || node.value == n2)
                   return node;

            // Look for keys in left and right subtrees
            Node left_lca = findLCAinBT(node.left, n1, n2);
            Node right_lca = findLCAinBT(node.right, n1, n2);

            // If both of the above calls return Non-NULL, then one key
            // is present in once subtree and other is present in other,
            // So this node is the LCA
            if (left_lca != null && right_lca != null)
                   return node;

            // Otherwise check if left subtree or right subtree is LCA
            return (left_lca != null) ? left_lca : right_lca;
     }
	
}
