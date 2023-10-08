//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends




/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/
class Solution {
    Node sortedInsert(Node head1, int key) {
        /*
        need to keep dummy node node and connect head, then find point of insertion move prev and curr
        */
        Node dummy = new Node(Integer.MIN_VALUE);
        dummy.next = head1;
        Node prev = dummy;
        Node curr = dummy.next;
        
        while (curr != null && curr.data < key){
            prev = curr;
            curr = curr.next;
        }
        
  
        
        Node new_node = new Node(key);
        prev.next = new_node;
        new_node.next = curr;
        return dummy.next;
    }
}