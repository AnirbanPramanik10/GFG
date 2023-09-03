//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends



class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
          int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        int min=Integer.MAX_VALUE, max=-1;
        
        for(int i=0;i<n;i++){
            min = Math.min(min, arr[i]);
                leftMin[i] = min;
        }
        for(int i=n-1;i>=0;i--){
            max = Math.max(max,arr[i]);
            rightMax[i] = max;
        }
        
        int l=0,r=0;
        int ans = -1;
        while (l < n && r < n){
            
            if (leftMin[l] <= rightMax[r]){
               ans = Math.max(ans, r-l);
                r++;
            }
            else{
                l++;
            }
        }
        
        
        return ans;
        
    }
}