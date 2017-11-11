package TreesLib;

import java.util.HashMap;

public class Whiteboard {

	static HashMap<Integer,TreeNode> htree = new HashMap<Integer,TreeNode>();
	
	public static void main(String args[])
	{
		
	Integer arr[] = { 0,1,2,3,4 } ;
		
	
		TreeNode root2 = arrayToTree(arr);
		
		
		
		TreeNode ca = commonAncestor(root2, htree.get(3), htree.get(4));
		
		System.out.println(ca.data);
		
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (covers(root.left, p) && covers(root.left, q))
			return commonAncestor(root.left, p, q);
		if (covers(root.right, p) && covers(root.right, q))
			return commonAncestor(root.right, p, q);
		return root;
	}
	
	private static boolean covers(TreeNode root, TreeNode p) { /* is p a child of root? */
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	public static TreeNode arrayToTree(Integer[] input){
	    TreeNode root = createTreeNode(input,1);
	    return root;
	}

	private static TreeNode createTreeNode(Integer[] input, int index){
	    if(index<=input.length){
	        Integer value = input[index-1];
	        if(value!=null){
	            TreeNode t = new TreeNode(value);
	            htree.put(value, t);
	            t.left = createTreeNode(input, index*2);
	            t.right = createTreeNode(input, index*2+1);
	            return t;
	        }
	    }
	    return null;
	}
}
