//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends




//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        // code here
        if(n==1){
            return 1;
        }
        int res=0;
        
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        
        for(int i=0; i<n; i++){
            dp[i] = new HashMap<>();
            for(int j=0; j<i; j++){
                
                int diff = A[i] - A[j];
                
                dp[i].put(diff, dp[j].getOrDefault(diff, 1)+1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}