//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends




//User function Template for Java
class Solution {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int i = 0, j = 0;
        long maxSum = 0, sum = 0;
        while (j < N) {
            if (j - i + 1 < K) {
                sum += Arr.get(j);
                j++;
            } else if (j - i + 1 == K) {
                sum += Arr.get(j);
                maxSum = Math.max(sum, maxSum);
                sum -= Arr.get(i);
                j++;
                i++;
            }
        }
        return maxSum;
    }
}