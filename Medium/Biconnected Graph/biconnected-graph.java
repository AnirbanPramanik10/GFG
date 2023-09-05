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
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            int[] arr = new int[2*e];
            
            for(int i=0; i<2*e; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.biGraph(arr,n,e));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    public void isArticulation(int src,int par,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int it[],int loin[],int time,TreeSet<Integer> hs)
    {
        vis[src]=true;
        it[src]=loin[src]=time++;
        int child=0;
        for(int x : adj.get(src))
        {
            if(x==par)
            continue;
            if(!vis[x])
            {
                isArticulation(x,src,adj,vis,it,loin,time,hs);
                loin[src]=Math.min(loin[src],loin[x]);
                if(loin[x]>=it[src] && par!=-1)
                hs.add(src);
                child++;
            }
            else
            loin[src]=Math.min(loin[src],it[x]);
        }
        if(par==-1 && child>1)
        hs.add(src);
    }
    int biGraph(int[] arr, int n, int e) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<arr.length;i+=2)
        {
            adj.get(arr[i]).add(arr[i+1]);
            adj.get(arr[i+1]).add(arr[i]);
        }
        int in[]=new int[n];
        int loin[]=new int[n];
        boolean vis[]=new boolean[n];
        Arrays.fill(in,-1);
        Arrays.fill(loin,-1);
        Arrays.fill(vis,false);
        int x=0;
        TreeSet<Integer> hs=new TreeSet<>();
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                x++;
            isArticulation(i,-1,adj,vis,in,loin,0,hs);
            }
        }
        if(hs.size()==0 && x==1)
        return 1;
        return 0;
        // code here
    }
}