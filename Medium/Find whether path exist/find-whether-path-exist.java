//{ Driver Code Starts
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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends





class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        boolean ans=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                   ans =  dfs(grid,i,j,grid.length,grid[0].length); 
                   break;
                }
            }
        }
        return ans;
    }
    private static boolean dfs(int grid[][],int i,int j,int n,int m){
        
        if(grid[i][j] == 2){
            return true;
        }
        grid[i][j] = 0;
        boolean left=false,right=false,up=false,down=false;
        //left
        if(isSafe(grid,i,j-1,n,m)){
            left = dfs(grid,i,j-1,n,m);
        }
        
        //right
        if(isSafe(grid,i,j+1,n,m)){
            right = dfs(grid,i,j+1,n,m);
        }
        
        //up
        if(isSafe(grid,i-1,j,n,m)){
           up= dfs(grid,i-1,j,n,m);
        }
        
        //down
        if(isSafe(grid,i+1,j,n,m)){
           down = dfs(grid,i+1,j,n,m);
        }
        
        if(left || right || up || down){
            return true;
        }
        
        return false;
    }
    
    private static boolean isSafe(int grid[][],int i,int j,int n,int m){
        if(i>=0 && j>=0 && i<n && j<m && grid[i][j]!=0){
            return true;
        }
        return false;
    }
}