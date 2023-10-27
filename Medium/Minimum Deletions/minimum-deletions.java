//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends



//User function Template for Java

class Solution{
     static int minimumNumberOfDeletions(String S) 
    {
      int n = S.length();
      int len = lps(S);
      return (n - len);
    }
    
    static int lps(String s)
    {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++)
            dp[i][i] = 1;
            
        for(int cl=2; cl<=n; cl++)
        {
            for(int i=0; i<n-cl+1; i++)
            {
                int j = i + cl - 1;
                if(s.charAt(i)==s.charAt(j) && cl == 2)
                {
                    dp[i][j] = 2;
                }
                else if(s.charAt(i)==s.charAt(j))
                     dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Integer.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        return dp[0][n-1];
}
}