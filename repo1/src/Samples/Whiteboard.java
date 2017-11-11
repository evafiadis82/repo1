package Samples;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import UtilLib.AssortedMethods;
import TreesLib.TreeLib;
import TreesLib.TreeNode;
import LinkedListLib.LinkedListLib;
import LinkedListLib.Node;
import LinkedListLib.LinkedListLib.*;

public class Whiteboard {

	public static void main(String[] args) {

		int[] array = { 2,1,3 };
		TreeNode root = TreeNode.createMinimalBST(array);
	 
		Integer[] arr = { 10,5,15,null,null,6,20};
		TreeNode root2 = TreeLib.arrayToTree(arr);
		
		System.out.println("Root: " + root.data);
		// System.out.println("Is balanced? " + TreeLib.isBalanced(root));

		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		// System.out.println("Root? " + unbalanced.data);
		// System.out.println("Is balanced? " + TreeLib.isBalanced(root));
		DFSStringPath(root);
		//DFSStringPath(root2);
		int reqsum = 2;
		//System.out.println("reqsum: " + reqsum + " " + DFSSumPath(root2, reqsum));
		// DFSStringPath(unbalanced);
		// inorderTraversal(root);
		System.out.println(isValidBST(root));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> lt = new ArrayList<Integer>();
		inorderhelper(root, lt);
		return lt;
	}

	public static void inorderhelper(TreeNode x, List<Integer> lt) {

		if (x == null)
			return;

		inorderhelper(x.left, lt);

		// System.out.print(x.data+ " ");
		lt.add(x.data);

		inorderhelper(x.right, lt);

	}

	public static void DFS(TreeNode root) {

		System.out.println("\n\nTree DFS algorithm:");

		if (root == null)
			return;

		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		while (st.isEmpty() != true) {
			TreeNode temp = st.pop();

			System.out.print(" " + temp.data);

			if (temp.left != null)
				st.push(temp.left);

			if (temp.right != null)
				st.push(temp.right);

		}

	}

	public static void DFSStringPath(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		List<String> str_list = new ArrayList<String>();
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		String str = Integer.toString(root.data);
		hmap.put(root.data, str);

		while (st.isEmpty() != true) {
			TreeNode temp = st.pop();

			str = hmap.get(temp.data);

			String tempstr = "";

			if (temp != root)
				tempstr = str + "->" + Integer.toString(temp.data);
			else
				tempstr = str;

			if (temp.left == null && temp.right == null) {
				System.out.println("Node " + temp.data + " | Leaf");
				hmap.put(temp.data, tempstr);
				str_list.add(tempstr);

			}

			if (temp.left != null) {
				System.out.println("Node " + temp.data + " | Left " + temp.left.data);
				st.push(temp.left);

				hmap.put(temp.left.data, tempstr);

			}

			if (temp.right != null) {
				System.out.println("Node " + temp.data + " | Right " + temp.right.data);
				st.push(temp.right);
				hmap.put(temp.right.data, tempstr);

			}

		}

		System.out.println("List: " + str_list);

	}

	public static boolean DFSSumPath(TreeNode root, int reqsum) {

		if (root == null)
			return false;

		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		HashMap<TreeNode, Integer> hmap = new HashMap<TreeNode, Integer>();
		int sum = root.data;
		hmap.put(root, sum);

		while (st.isEmpty() != true) {
			TreeNode temp = st.pop();

			sum = hmap.get(temp);
			
			//System.out.println("Node " + temp.data);
			
			int tempsum;

			if (temp != root)
				tempsum = sum + temp.data;
			else
				tempsum = sum;

			if (temp.left == null && temp.right == null) {

				hmap.put(temp, tempsum);
				
				//System.out.println(tempsum+ " " + reqsum);
				
				if (tempsum == reqsum)
					return true;

			}

			if (temp.left != null) {

				st.push(temp.left);

				hmap.put(temp.left, tempsum);

			}

			if (temp.right != null) {

				st.push(temp.right);
				hmap.put(temp.right, tempsum);

			}

		}
		return false;
	}

	  public static boolean isValidBST(TreeNode root) {
	     
		  if (root==null)
		  return true;
			  
		  if (root.left!=null && root.left.data>root.data)
			  return false;
		  
		  if (root.right!=null && root.right.data<root.data)
			  return false;
		  
		  return (isValidBST(root.left) && isValidBST(root.right));
	    }
	
}
