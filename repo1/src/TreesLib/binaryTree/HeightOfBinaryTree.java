package TreesLib.binaryTree;

import TreesLib.Node;

public class HeightOfBinaryTree {

	public int heightOfBinaryTree(Node node)
	{
	    if (node == null)
	    {
	        return 0;
	    }
	    else
	    {
	        return 1 + Math.max(heightOfBinaryTree(node.left), heightOfBinaryTree(node.right));
	    }
	}
	
}
