package TreesLib;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

	
	public static void BFS(TreeNode root)
	    {
		  
		System.out.println("Tree BFS algorithm");
		
		 Queue queue=new LinkedList<TreeNode>();
	        
		 queue.add(root);
	     
		 while(!queue.isEmpty())
	        {
	        TreeNode tempNode=(TreeNode)queue.poll();
	        
	        System.out.print(tempNode.data + " "); 
	        
	        if(tempNode.left!=null)
	        queue.add(tempNode.left);
	        
	        if(tempNode.right!=null)
	         queue.add(tempNode.right);
	      
	        }
	    }
	
	    
	    }