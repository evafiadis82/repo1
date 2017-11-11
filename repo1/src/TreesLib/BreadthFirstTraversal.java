package TreesLib;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

	
	 void printLevelOrder(Node root)
	    {
		  Queue queue=new LinkedList();
	        queue.add(root);
	        while(!queue.isEmpty())
	        {
	        Node tempNode=(Node)queue.poll();
	        System.out.print(tempNode.value);
	        if(tempNode.left!=null)
	        queue.add(tempNode.left);
	        if(tempNode.right!=null)
	         queue.add(tempNode.right);
	        }
	    }
	
	    
	    }