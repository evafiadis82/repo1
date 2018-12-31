package TreesLib;

import TreesLib.TreeNode;

public class TreeLib {

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	// a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one
	public static boolean isBalanced(TreeNode root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}

	// checks if it is a valid binary search tree
	public static boolean isBST(Node root) {
		if (root.left != null) {
			if (root.value < root.left.value || !isBST(root.left)) {
				return false;
			}
		}

		if (root.right != null) {
			if (root.value > root.right.value || !isBST(root.right)) {
				return false;
			}
		}

		return true;
	}

	// create tree - Minimal BST
	private static TreeNode addToTree(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(addToTree(arr, start, mid - 1));
		n.setRightChild(addToTree(arr, mid + 1, end));
		return n;
	}

	public static TreeNode createMinimalBST(int array[]) {
		return addToTree(array, 0, array.length - 1);
	}

	//return common Ancestor of two nodes in tree
	public Node commonAncestor(Node root, Node p, Node q) {
		if (covers(root.left, p) && covers(root.left, q))
			return commonAncestor(root.left, p, q);
		if (covers(root.right, p) && covers(root.right, q))
			return commonAncestor(root.right, p, q);
		return root;
	}

	private boolean covers(Node root, Node p) { /* is p a child of root? */
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	public static int depth(Node root, Node x) { //returns distance from root
		if (root == null)
			return -1;
		if (x.value == root.value)
			return 0;

		else if (x.value < root.value) {
			return depth(root.left, x) + 1;

		} else
			return depth(root.right, x) + 1;
	}

	public static int distance_between_node(Node root, Node left, Node right) {
		int distance;

		if (left == right)
			return 0;
		else if (left == root)
			return depth(root, right);
		else if (right == root)
			return depth(root, left);

		Node greater = left.value > right.value ? left : right;
		Node smaller = left.value < right.value ? left : right;

		if (root.value > smaller.value && root.value < greater.value) {
			distance = depth(root, left) + depth(root, right);
			return distance;

		} else
			return depth(root, smaller) - depth(root, greater);
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
	            t.left = createTreeNode(input, index*2);
	            t.right = createTreeNode(input, index*2+1);
	            return t;
	        }
	    }
	    return null;
	}
	
}
