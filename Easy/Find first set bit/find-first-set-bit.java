//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends



//User function Template for Java

class Solution {
    // Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n) {
        int position = 1;
        // If n is 0, there are no set bits.
        if (n == 0) {
            return 0;
        }
        // Iterate through the binary representation from right to left.
        while ((n & 1) == 0) {
            n >>= 1; // Right shift to check the next bit.
            position++;
        }
        return position;
    }
}