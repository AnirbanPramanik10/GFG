//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends



//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) {
        Map<Node, Node> map = new HashMap<>();
        Node targetNode = bfs(map, root, target);
        return findTime(map, targetNode);
    }
    
    private static Node bfs(Map map, Node root, int target) {
        Queue<Node> q = new LinkedList<>();
        Node result = new Node(-1);
        q.offer(root);
        
        while(!q.isEmpty()) {
            Node temp = q.poll();
            if(temp.data == target) result = temp;
            
            if(temp.left != null) {
                map.put(temp.left, temp);
                q.offer(temp.left);
            }
            
            if(temp.right != null) {
                map.put(temp.right, temp);
                q.offer(temp.right);
            }
        }
        
        return result;
    }
    
    private static int findTime(Map<Node, Node> map, Node targetRoot) {
        Map<Node, Integer> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        int time = 0;
        q.offer(targetRoot);
        visited.put(targetRoot, 1);
        
        while(!q.isEmpty()) {
            int size = q.size();
            int flag = 0;
            
            for(int i = 0; i < size; i++) {
                Node temp = q.poll();
                
                if(temp.left != null && visited.get(temp.left) == null) {
                    flag = 1;
                    visited.put(temp.left, 1);
                    q.offer(temp.left);
                }
                
                if(temp.right != null && visited.get(temp.right) == null) {
                    flag = 1;
                    visited.put(temp.right, 1);
                    q.offer(temp.right);
                }
                
                if(map.get(temp) != null && visited.get(map.get(temp)) == null) {
                    flag = 1;
                    visited.put(map.get(temp), 1);
                    q.offer(map.get(temp));
                }
            }
            
            if(flag == 1) time++;
        }
        
        return time;
    } 
}