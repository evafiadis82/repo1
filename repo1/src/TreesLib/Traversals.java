package TreesLib;

import java.util.Stack;

public class Traversals {

	public void preorderTraversalIter(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		while (stack.size() > 0) {

			TreeNode curr = stack.pop();

			System.out.println(curr.data);

			TreeNode n = curr.right;

			if (n != null)
				stack.push(n);
			n = curr.left;
			if (n != null)
				stack.push(n);
		}
	}

	public static void inOrderTraversal (TreeNode current, int[] data )
	{
		if (current==null)
			return;
		
		inOrderTraversal (current.left, data );
		
		data[1] = Math.min(data[1], Math.abs(current.data -data[0]) );
		data[0] = current.data;
		
		inOrderTraversal (current.right, data );
		
	}
	
	
	public static void preOrderTraversal (TreeNode current, int[] data )
	{
		if (current==null)
			return;
	
		data[1] = Math.min(data[1], Math.abs(current.data -data[0]) );
		data[0] = current.data;
				
		preOrderTraversal (current.left, data );
		preOrderTraversal (current.right, data );
		
	}
	
	public static void postOrderTraversal (TreeNode current, int[] data )
	{
		if (current==null)
			return;
	
		postOrderTraversal (current.left, data );
		postOrderTraversal (current.right, data );
	
		data[1] = Math.min(data[1], Math.abs(current.data -data[0]) );
		data[0] = current.data;
				
	}
	
}
