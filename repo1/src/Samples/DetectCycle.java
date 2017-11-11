package Samples;

import java.util.HashMap;
/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

public class DetectCycle {

boolean hasCycle(Node head) {
   
    Node fast = head;
    Node slow = head;
     
    while (slow!=null && fast!=null && fast.next!=null )
        {
        
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast)
            return true;
      
        }
    
    
    return false;
    
}
}