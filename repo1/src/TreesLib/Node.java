package TreesLib;



public class Node 
{
public int value;
public Node left;
public Node right;

public Node(int x)
{
	this.value = x;
}

Node(int item , Node left, Node right )
{
    this.value=item;
    this.left=left;
    this.right=right;
}

}