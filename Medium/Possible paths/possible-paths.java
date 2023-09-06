//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] graph = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    graph[i][j] = Integer.parseInt(S[j]);
            }
            String[] S1 = br.readLine().trim().split(" ");
            int u = Integer.parseInt(S1[0]);
            int v = Integer.parseInt(S1[1]);
            int k = Integer.parseInt(S1[2]);
            Solution ob = new Solution();
            int ans = ob.MinimumWalk(graph, u, v, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int MinimumWalk(int[][] graph, int u, int v, int k){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(graph[i][j]==1)
                    adj.get(i).add(j);
            }
        }
        int n=graph.length;
        int[][] dp=new int[n][k+1];
        dp[u][0]=1;
        for(int len=1;len<=k;len++){
            for(int i=0;i<n;i++){
                for(int j=0;j<adj.get(i).size();j++){
                    int num = adj.get(i).get(j);
                    dp[num][len]+=dp[i][len-1];
                    dp[num][len]%=1000000007;
                }
            }
        }
        return dp[v][k];
    }
}