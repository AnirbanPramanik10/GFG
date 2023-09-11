//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends




//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		int n=costs.length;
		int k=costs[0].length;
		
		int[][] dp=new int[k][n];
		int min=Integer.MAX_VALUE, smin=Integer.MAX_VALUE;
		for(int i=0;i<k;i++)
		{
		    dp[i][0]=costs[0][i];
		    
		    if(costs[0][i]<min)
		    {
		        smin=min;
		        min=costs[0][i];
		    }
		    else if(costs[0][i]<smin)
		        smin=costs[0][i];
		}
		
		int cmin,csmin;
		
		for(int i=1;i<n;i++)
		{
		    cmin=Integer.MAX_VALUE; csmin=Integer.MAX_VALUE;
		    for(int j=0;j<k;j++)
		    {
		        if(dp[j][i-1]==min) dp[j][i]=costs[i][j]+smin;
		        else dp[j][i]=costs[i][j]+min;
		        
		        if(dp[j][i]<cmin)
		        {
		            csmin=cmin;
		            cmin=dp[j][i];
		        }
		        else if(dp[j][i]<csmin)
		        {
		            csmin=dp[j][i];
		        }
		    }
		    
		    min=cmin;
		    smin=csmin;
		}
		
		
		    return min==Integer.MIN_VALUE?-1:min;
	}
}