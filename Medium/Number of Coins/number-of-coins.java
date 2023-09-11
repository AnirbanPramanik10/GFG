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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends



class Solution{
    public static int mm;
    public static int memo[][];
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    mm=V;
	    memo=new int[M+1][V+1];
	    for(int i=0;i<=M;i++)
	    {
	        for(int j=0;j<=V;j++)
	        {
	            memo[i][j]=-1;
	        }
	    }
	    int cc=solve(coins,M,V);
	    return cc==mm?-1:cc;
	} 
	public int solve(int []coins,int n,int w)
	{
	    if(w==0)
	    {
	        return 0;
	    }
	    if(n==0)
	    {
	        return mm;
	    }
	    if(memo[n][w]!=-1)
	    {
	        return memo[n][w];
	    }
	    if(coins[n-1]<=w)
	    {
	        return memo[n][w]=Math.min(1+solve(coins,n,w-coins[n-1]),solve(coins,n-1,w));
	    }
	    else
	    {
	        return memo[n][w]=solve(coins,n-1,w);
	    }
	}
}