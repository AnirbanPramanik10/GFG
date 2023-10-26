//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java



//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
          if(n==1) return 1;
        if(n==2) return 2;
        int steps=2;
        while(n>2){
            if(n%2==0){
                n=n/2;
            }
            else{
                n=n-1;
            }
            steps++;
        }
        return steps;
    }
}