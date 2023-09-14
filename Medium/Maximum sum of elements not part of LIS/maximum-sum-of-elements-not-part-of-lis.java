//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[] = new int[n];
            for (int i = 0; i < n; i++)
                Arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxSumLis(Arr, n));
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {
    static int maxSumLis(int Arr[], int n) {
        int sum=0;
        for(int val : Arr) sum+=val;
        int dp[][]=new int[n][2];
        int fres=0,flen=0;
        for(int i=0;i<n;i++){
            int len=1,sm=Arr[i];
            for(int j=i-1;j>=0;j--){
                if(Arr[j]<Arr[i]){
                    int clen=dp[j][1]+1;
                    int csum=dp[j][0]+Arr[i];
                    if(clen>len){
                        len=clen;
                        sm=csum;
                    } else if(clen==len) sm=Math.min(sm,csum);
                }
            }
            dp[i][0]=sm;
            dp[i][1]=len;
            if(flen<len){
                flen=len;
                fres=sm;
            } else if(flen==len){
                fres=Math.min(fres,sm);
            }
        }
        
        return sum-fres;
    }
}