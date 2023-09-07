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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Solution
{
    int max = 0;
    int[][] dir = {{-1,-1},{-1,1},{1,-1},{1,1},{0,-1},{0,1},{-1,0},{1,0}};
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // int count = 0;
                if(grid[i][j] == 1){
                    int[] count = {0};
                    dfs(i,j, grid, count);
                    max = Math.max(count[0], max);
                }
            }
        }
        return max;
    }
    public void dfs(int row, int col, int[][] grid, int[] count){
        if(row >= grid.length || col >= grid[0].length || col < 0 || row < 0 || grid[row][col] == 0){
            return;
        }
        count[0] += grid[row][col];
        grid[row][col] = 0;
        for(int[] d : dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            dfs(newRow, newCol, grid, count);
        }
        return;
    }
}