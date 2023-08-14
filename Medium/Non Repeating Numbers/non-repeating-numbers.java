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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
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
    public int[] singleNumber(int[] nums)
    {
        int arr[] = new int[2];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums){
            if(hmap.containsKey(i)){
                hmap.put(i,hmap.get(i)+1);
            }else{
                hmap.put(i,1);
            }
        }
        int i = 0;
        for(Map.Entry<Integer,Integer> ent : hmap.entrySet()){
            if(ent.getValue() == 1){
                arr[i++] = ent.getKey();
            }
        }
        Arrays.sort(arr);
        return arr;
    }
}