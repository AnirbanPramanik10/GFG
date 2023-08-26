//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        HashMap<Character,Integer> mp=new HashMap<>();
        int j=0;
        int ans=-1;
        for(int i=0;i<s.length();i++)
        {
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            while(mp.size()>k)
            {
                mp.put(s.charAt(j),mp.get(s.charAt(j))-1);
                if(mp.get(s.charAt(j))==0)
                mp.remove(s.charAt(j));
                j++;
            }
            if(mp.size()==k)
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}