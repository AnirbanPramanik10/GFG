//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N-1];
            
            for(int i=0; i<N-1; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.socialNetwork(arr,N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static String socialNetwork(int[] arr, int N) {
        // code here
        String s = "";
       for(int i = 0; i < arr.length; i++){
           int j = arr[i];
           int count = 1;
           String a = i+2 + " " + arr[i] + " " + 1 + " ";
           Stack<String> st = new Stack<String>();
           st.push(a);
           while(j-2 >= 0){
               count++;
               j = arr[j-2];
               a = i+2 + " " + j + " " + count + " ";
               st.push(a);
           }
           while(!st.isEmpty()){
               s+=st.peek();
               st.pop();
           }
       }
       return s;
    }
};