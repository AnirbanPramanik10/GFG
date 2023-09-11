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
            String[] s = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            int[] ans = obj.DistinctSum(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int[] DistinctSum(int[] nums)
    {
        int n=nums.length;
        int k=0;
        for(int i=0;i<n;i++)
        k=k+nums[i];
         boolean dp[][]= new boolean[n][k+1];
    
    for(int i=0; i<n; i++){
        dp[i][0] = true;
    }
    
    if(nums[0]<=k)
        dp[0][nums[0]] = true;
    
    for(int ind = 1; ind<n; ind++){
        for(int target= 1; target<=k; target++){
            
            boolean notTaken = dp[ind-1][target];
    
            boolean taken = false;
                if(nums[ind]<=target)
                    taken = dp[ind-1][target-nums[ind]];
        
            dp[ind][target]= notTaken||taken;
        }
    }
       ArrayList<Integer> arr=new ArrayList<>();
       int count=0;
       for(int i=0;i<=k;i++)
       {
           if(dp[nums.length-1][i]==true)
           {
              arr.add(i);
           }
       }
      int [] res=new int [arr.size()];
      for(int i=0;i<res.length;i++)
      res[i]=arr.get(i);
      return res;
      
    }
}