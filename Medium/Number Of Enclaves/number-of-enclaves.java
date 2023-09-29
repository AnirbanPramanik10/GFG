//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends






// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        int[][] visit = new int[m][n];
        for(int i=0;i<n;i++)
        {
            if(nums[0][i] == 1)
                dfs(0,i,nums);
            if(nums[m-1][i] == 1)
                dfs(m-1,i,nums);
        }
        for(int i=1;i<m-1;i++)
        {
            if(nums[i][0] == 1)
                dfs(i,0,nums);
            if(nums[i][n-1] == 1)
                dfs(i,n-1,nums);
        }
        int max = 0;
        for(int i=1;i<m-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                if(nums[i][j] == 1)
                    max++;
            }
        }
        return max;
    }
    public void dfs(int i, int j, int[][] nums)
    {
        int m = nums.length, n = nums[0].length;
        if(i<0 || j<0 || i==m || j==n || nums[i][j]==0)
            return;
        nums[i][j] = 0;
        dfs(i-1,j,nums);
        dfs(i+1,j,nums);
        dfs(i,j-1,nums);
        dfs(i,j+1,nums);
        
    }
}