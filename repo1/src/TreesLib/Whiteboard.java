package TreesLib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Whiteboard {

	static HashMap<Integer,TreeNode> htree = new HashMap<Integer,TreeNode>();
	
	public static void main(String args[])
	{
		
	Integer arr[] = { 100, 50 , 25, 75, 150, 125, 110, 175} ;
		
	
		//TreeNode root2 = arrayToTree(arr);
		
			TreeNode root = null;
			for (int i=0; i<arr.length;i++) {
				int data = arr[i];
				root = insert(root, data);
			}
		
		int nums[] = new int[2];
		nums[0] = Integer.MAX_VALUE; // previous
		nums[1] = Integer.MAX_VALUE; // min
		
		//inOrderTraversal (root,nums); 
		//postOrderTraversal (root,nums);
		printTreepreOrder(root);
		//System.out.println(nums[1]);
		
		DepthFirstTraversal.DFS(root);
		BreadthFirstTraversal.BFS(root);
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
				
		inOrderTraversal (current.left, data );
		inOrderTraversal (current.right, data );
		
	}
	
	public static void postOrderTraversal (TreeNode current, int[] data )
	{
		if (current==null)
			return;
	
		inOrderTraversal (current.left, data );
		inOrderTraversal (current.right, data );
	
		data[1] = Math.min(data[1], Math.abs(current.data -data[0]) );
		data[0] = current.data;
				
	}
	
	
	public static void  findMinimumDistanceBetweenBSTNodes (TreeNode root, HashSet s)
	{
		if (root==null)
			return;
		
		s.add(root.data);
		
		findMinimumDistanceBetweenBSTNodes (root.left, s);
		findMinimumDistanceBetweenBSTNodes (root.right, s);
		
		return;
	}
	
	
	
	
	
	
	
	public static void printTreepreOrder (TreeNode root2) //LeftRootRight
	{
		
		if (root2==null)
		return;
		
		System.out.println("Node: " +  root2.data);
		
		System.out.println("\nLeft");
		printTreepreOrder(root2.left);
		
		System.out.println("\nRight");
		printTreepreOrder(root2.right);
	}
	
	
	public static TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
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
