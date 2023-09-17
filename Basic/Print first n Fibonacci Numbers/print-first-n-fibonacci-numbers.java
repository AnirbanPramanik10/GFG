//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends




//User function Template for Java


class Solution
{
    public static long[] printFibb(int n) {
    if (n <= 0) {
        return new long[0]; // Return an empty array for n <= 0
    } else if (n == 1) {
        return new long[]{1}; // Return an array containing 0 for n = 1
    } else {
        long[] fibSeries = new long[n]; // Create an array to store the Fibonacci series

        // Initialize the first two elements of the series
        fibSeries[0] = 1;
        fibSeries[1] = 1;

        for (int i = 2; i < n; i++) {
            // Calculate the next Fibonacci number
            fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
        }

        return fibSeries; // Return the Fibonacci series as an array
    }
}

}