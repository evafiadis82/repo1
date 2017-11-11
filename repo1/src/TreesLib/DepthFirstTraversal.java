package TreesLib;

import java.util.Stack;

public class DepthFirstTraversal {

	//DFT depth first traversal
	
	//preorder RoLR
	//inorder  LRoR
	//postorder LRRo
	
	//O(n) complexity to read all nodes of tree
	
	
	public void preorder (Node x)
	{
		
		if (x==null)
			return;
		
		
		System.out.println(x.value);
		
		preorder(x.left);
		
		preorder(x.right);
		
	}
	
	public void inorder (Node x)
	{
		
		if (x==null)
			return;
		
		inorder(x.left);
		
		System.out.println(x.value);
					
		inorder(x.right);
		
	}
	
	
	public void postorder (Node x)
	{
		
		if (x==null)
			return;
		
		postorder(x.left);
					
		postorder(x.right);
		
		System.out.println(x.value);
	}
	
	
	public static void DFS(TreeNode root) {

		System.out.println("Tree DFS algorithm");
		
		if (root == null)
			return;

		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		while (st.isEmpty() != true) {
			TreeNode temp = st.pop();

			System.out.println("Node " + temp.data);

			if (temp.left != null)
				st.push(temp.left);

			if (temp.right != null)
				st.push(temp.right);

		}

	}

	
}

 //TreeTraversal
