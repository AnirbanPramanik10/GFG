//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends



// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
         
         if(arr.length<4) return ans;
         Set<ArrayList<Integer>> st = new HashSet<>();
        for(int i=0;i<arr.length-3;i++){
            for(int j=i+1;j<arr.length-2;j++){
                int left = j+1; int right = arr.length-1;
                while(left<right){
                    int sum = arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum==k){
                        ArrayList<Integer> l=new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        if(!st.contains(l)){
                            ans.add(l);
                            st.add(l);
                        }
                        left++;
                        right--;
                    } else if(sum<k) left++;
                    else right--;
                }
                    
                }
            }
            
            return ans;
        }
    }